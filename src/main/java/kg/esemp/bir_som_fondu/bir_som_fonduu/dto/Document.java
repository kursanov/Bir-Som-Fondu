package kg.esemp.bir_som_fondu.bir_som_fonduu.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "document_gen")
    @SequenceGenerator(
            name = "document_gen",
            sequenceName = "document_seq",
            allocationSize = 1, initialValue = 11)
    private Long id;

    private Long campaignId;

    @Column(name = "file_path") // Обычное поле в этой же таблице
    private String filePath;

    private LocalDate uploadedAt;
}






