package de.gruene.haustuer.user;

import java.util.Collection;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public boolean confirm(final User user) {
        final User userFromDB = this.userRepo.findByEmail(user.getEmail());
        // TODO implement proper error codes
        if (userFromDB.getUid().equals(user.getUid()) && BCrypt.checkpw(user.getPassword(), userFromDB.getPassword())) {
            userFromDB.setIsConfirmed(true);
            this.userRepo.save(userFromDB);
            return true;
        }
        return false;
    }

    public boolean create(final User user) {
        if (this.userRepo.existsByEmail(user.getEmail())) {
            return false;
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setIsConfirmed(false);
        user.setUid(UUID.randomUUID().toString());
        // TODO send email
        this.userRepo.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmailAndIsConfirmedTrue(username);
        if (user == null) {
          throw new UsernameNotFoundException("User=" + username + " not found.");
        }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                // every user has ROLE_USER
                return AuthorityUtils.createAuthorityList("ROLE_USER");
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return user.getIsConfirmed();
            }
        };
    }
}
