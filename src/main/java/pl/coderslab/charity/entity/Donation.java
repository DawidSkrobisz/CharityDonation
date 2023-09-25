package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donation")
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    Integer quantity;
    @ManyToMany
    @JoinTable(name = "donation_category",
            joinColumns = @JoinColumn(name = "donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
    @ManyToOne
    private Institution institution;
    @NotNull
    String street;
    @NotNull
    String city;
    @NotNull
    String zipCode;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate pickUpDate;
    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    LocalTime pickUpTime;
    String pickUpComment;
}