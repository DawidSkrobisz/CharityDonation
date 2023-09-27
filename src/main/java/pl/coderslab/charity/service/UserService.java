package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Użytkownik o podanym adresie email już istnieje");
        }
   //     String encodedPassword = passwordEncoder.encode(user.getPassword());
   //     user.setPassword(encodedPassword);

        return userRepository.save(user);
    }
    
    public List<User> userList() {
        return userRepository.findAll();
    }
}