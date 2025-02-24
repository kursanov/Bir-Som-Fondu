package kg.esemp.bir_som_fondu.bir_som_fonduu.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "donations")
@Getter
@Setter
@NoArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "donation_gen")
    @SequenceGenerator(
            name = "donation_gen",
            sequenceName = "donation_seq",
            allocationSize = 1, initialValue = 11)
    private Long id;
    private Long donorId;
    private BigDecimal amount;
    private String paymentMethod;
    private LocalDate dateDonation;

    @ManyToOne
    @JoinColumn(name = "fundraisingCampaign_id")
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
