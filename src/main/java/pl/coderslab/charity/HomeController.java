package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);
        Integer quantity = donationRepository.countQuantity();
        model.addAttribute("quantity", quantity);
        Integer gives = categoryRepository.countGives();
        model.addAttribute("gives", gives);
        return "index";
    }
}