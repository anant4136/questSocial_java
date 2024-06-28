package com.forum.forum.service;

import com.forum.forum.entity.Company;
import com.forum.forum.entity.User;
import com.forum.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) throws Exception{
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("user already present");
            throw new Exception("user already present");
        }
        else{
            local = this.userRepository.save(user);
        }
        return local;
    }

    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    public User updateUser(User user){
        return (User)this.userRepository.save(user);
    }
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }
    public User getUserById(Long id) {
        return this.userRepository.findById(id).get();
    }
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }
    public List<User> getAllCompanyUsers(Company company) {
        return this.userRepository.findByCompany(company);
    }

    public List<User> getAllCompanyUsersTop10(Company company) {
    List<User> users = userRepository.findByCompany(company);
    // Sort the list based on the score field
    users.sort(Comparator.comparingInt(User::getScore).reversed());
    // Return the top 10 users if available, or all users if less than 10
    return users.stream().limit(10).collect(Collectors.toList());
 }


}