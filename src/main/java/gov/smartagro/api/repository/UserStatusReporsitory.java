package gov.smartagro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.smartagro.api.model.Userstatus;


@Repository
public interface UserStatusReporsitory extends JpaRepository<Userstatus, Long> {

	Userstatus findByUserid(Long userId);

}
