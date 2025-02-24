package kg.esemp.bir_som_fondu.bir_som_fonduu.dto;

import jakarta.persistence.*;
import kg.esemp.bir_som_fondu.bir_som_fonduu.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campaign")
@Getter
@Setter
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "campaign_gen")
    @SequenceGenerator(
            name = "campaign_gen",
            sequenceName = "campaign_seq",
            allocationSize = 1, initialValue = 11)
    private Long id;
    private String title;
    private String description;
    private BigDecimal goalAmount;
    private BigDecimal collectedAmount;
    private Long recipientId;
    private Status status;
    private LocalDate startDate;
    private LocalDate andDate;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Donation> donations;

}
