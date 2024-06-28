package com.forum.forum.controller;

import com.forum.forum.entity.Company;
import com.forum.forum.entity.User;
import com.forum.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/")
    public User createUser(@RequestBody User user
//            , @RequestParam("Images") MultipartFile[] Images
    ) throws Exception {
//            String uploadDirectory = "src/main/resources/static";
//        String adsImagesString = "";

//        for (MultipartFile imageFile : Images) {
//            adsImagesString += imageService.saveImageToStorage(uploadDirectory, imageFile) + ",";
//        }
        return this.userService.createUser(user);
    }
    @GetMapping("/{username}")
    public User getUser (@PathVariable ("username") String username)
    {
        return this.userService.getUser(username);
    }
    @GetMapping("/id/{id}")
    public User getUserById (@PathVariable ("id") Long id)
    {
        return this.userService.getUserById(id);
    }
    @GetMapping("/company/{companyId}")
    public List<User> getCompanyUser (@PathVariable ("companyId") Long companyId)
    {
        Company company = new Company();
        company.setCompanyId(companyId);
        return this.userService.getAllCompanyUsers(company);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser (@PathVariable ("userId") Long userId)
    {
        this.userService.deleteUser(userId);
    }
    @GetMapping("/")
    public List<User> getAllUser ()
    {
        return this.userService.getAllUser();
    }
    @GetMapping("top10/company/{companyId}")
    public List<User>getTopCompanyUsers(@PathVariable Long companyId) {
        Company company = new Company();
        company.setCompanyId(companyId); // Assuming Company entity has a setId method
        List<User> users = userService.getAllCompanyUsers(company);
        return users;
    }
    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {

            User updatedUser = userService.updateUser(user);
            return updatedUser;

    }

}
