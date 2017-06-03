package de.gruene.haustuer.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usr")
public class User {

    @NotNull
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Boolean isConfirmed;

    @NotNull
    private String name;

    @NotNull
    private String password;

    private String uid;

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (this.email == null) {
            if (other.email != null)
                return false;
        } else if (!this.email.equals(other.email))
            return false;
        if (this.id != other.id)
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        if (this.password == null) {
            if (other.password != null)
                return false;
        } else if (!this.password.equals(other.password))
            return false;
        return true;
    }

    public String getEmail() {
        return this.email;
    }

    public long getId() {
        return this.id;
    }

    public Boolean getIsConfirmed() {
        return this.isConfirmed;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
        return result;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setIsConfirmed(final Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUid(final String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", password=" + this.password
                + "]";
    }
}
