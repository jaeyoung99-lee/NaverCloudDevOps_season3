package guest.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestDto, Integer>{

}
