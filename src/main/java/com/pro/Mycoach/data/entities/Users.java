package com.pro.Mycoach.data.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "\"Users\"")
public class Users extends BaseEntity{

    @NotNull
    protected String username;

    @NotNull
    protected String password;

    @NotNull
    protected String Name;

    @NotNull
    protected String description;

    @NotNull
    protected String emailAddress;


    public Users(String username, String password, String Name, String description, String emailAddress) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.Name = Name;
        this.description = description;
        this.emailAddress = emailAddress;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return password;
    }
}
