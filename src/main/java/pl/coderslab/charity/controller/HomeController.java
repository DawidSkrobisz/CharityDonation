package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionService.listInstitution();
        model.addAttribute("institutions", institutions);
        Integer quantity = donationService.SumOfQuantity();
        model.addAttribute("quantity", quantity);
        long gives = donationService.SumOfDonations();
        model.addAttribute("gives", gives);
        return "index";
    }
}