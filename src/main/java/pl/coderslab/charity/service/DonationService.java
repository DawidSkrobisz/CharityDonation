package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Integer SumOfQuantity() {
        return donationRepository.countQuantity();
    }

    public long SumOfDonations() {
        return donationRepository.gives();
    }

    public void saveDonation (Donation donation) {
        donationRepository.save(donation);
    }
}