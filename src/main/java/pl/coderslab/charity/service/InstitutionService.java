package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Institution> listInstitution() {
        return institutionRepository.findAll();
    }
}