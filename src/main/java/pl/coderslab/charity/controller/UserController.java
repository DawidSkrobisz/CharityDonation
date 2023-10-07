package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public String registerForm(Model model) {
        return "register";
    }

    @PostMapping("")
    public String registerSubmit(User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.userList();
        model.addAttribute("users", users);
        return "user/list";
    }


}