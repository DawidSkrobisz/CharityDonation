package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;

@AllArgsConstructor
@Controller
@RequestMapping("/form")
public class DonationController {

    @GetMapping
    public String form(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping
    public String form() {
        return "form-confirmation";
    }
}