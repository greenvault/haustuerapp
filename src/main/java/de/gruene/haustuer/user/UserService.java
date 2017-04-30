package de.gruene.haustuer.user;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

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

}
