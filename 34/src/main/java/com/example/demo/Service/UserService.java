package com.example.demo.Service;


import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepo repo;
   private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        if (repo.findByLogin(user.getLogin()) != null) return false;

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.USER);
        repo.save(user);
        log.info("save new user login: " + user.getLogin());
        return true;
    }
    public Iterable<User> getAll(){return repo.findAll();}
    public void add(User data){repo.save(data);}
    public void del(Long id){repo.deleteById(id);}

    public Optional<User> getById(Long id){return repo.findById(id);}

}
