package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/form")
public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @Autowired
    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping
    public String form(Model model) {
        model.addAttribute("donation", new Donation());
        List<Category> categoryList = categoryService.List();
        model.addAttribute("categoryList" , categoryList);
        return "form";
    }

    @PostMapping
    public String form(@ModelAttribute ("donation") Donation donation) {
        return "form-confirmation";
    }
}