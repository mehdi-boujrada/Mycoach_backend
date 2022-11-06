package com.pro.Mycoach.services;

import com.pro.Mycoach.data.entities.Authority;
import com.pro.Mycoach.data.entities.Users;
import com.pro.Mycoach.data.repositories.AuthorityRepo;
import com.pro.Mycoach.data.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    AuthorityRepo authorityRepo;

    public void createUser(String username, String password, String Name, String description, String emailAddress) {

        String[] authorities = {"ROLE_ATHLETE", "ROLE_COACH"};
        create(username, password, Name, description, emailAddress, authorities);
    }

    private void create(String username, String password, String Name, String description, String emailAddress, String[] authorities) {

        Users users = new Users(username, password, Name, description, emailAddress);
        usersRepo.save(users);
        for (String auth : authorities) {
            Authority authority = new Authority(username, auth);
            authorityRepo.save(authority);
        }
    }
    public void update(long userId, String password, String newPassword, String Name, String description,
                       String emailAddress) {
        Users users = usersRepo.findById(userId).get();
        if (password != null && (newPassword == null
                || !(new BCryptPasswordEncoder().encode(password).equals(users.getPassword())))) {
            return;
        }

        if (newPassword != null)
            users.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        if (Name != null)
            users.setName(Name);
        if (description != null)
            users.setDescription(description);
        if (emailAddress != null)
            users.setEmailAddress(emailAddress);

        usersRepo.save(users);
    }
}
