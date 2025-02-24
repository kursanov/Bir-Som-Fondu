package kg.esemp.bir_som_fondu.bir_som_fonduu.dto;

import jakarta.persistence.*;
import kg.esemp.bir_som_fondu.bir_som_fonduu.enums.Action;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "moderation_logs")
@Getter
@Setter
@NoArgsConstructor
public class ModerationLogs {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "moderation_logs_gen")
    @SequenceGenerator(
            name = "moderation_logs_gen",
            sequenceName = "moderation_logs_seq",
            allocationSize = 1, initialValue = 11)
    private Long id;
    private Long campaignId;
    private Long adminId;
    private Action action;
    private String commentAdmin;
    private LocalDate timeStamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User admin;
}
