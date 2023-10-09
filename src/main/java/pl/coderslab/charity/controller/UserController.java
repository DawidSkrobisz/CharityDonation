package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
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

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model model,
                              HttpServletRequest request) {

        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticated = authenticationManager.authenticate(authentication);

        if (authenticated.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticated);
            return "redirect:/";
        } else {
            model.addAttribute("loginError", "Błędny email lub hasło");
            return "login";
        }
    }
}