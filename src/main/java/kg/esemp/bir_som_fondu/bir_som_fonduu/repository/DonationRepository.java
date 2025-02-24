package kg.esemp.bir_som_fondu.bir_som_fonduu.repository;


import kg.esemp.bir_som_fondu.bir_som_fonduu.dto.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation,Long> {
}
