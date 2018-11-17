package gov.smartagro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.smartagro.api.model.UserCrop;


@Repository
public interface UserCropRepository extends JpaRepository<UserCrop, Long> {

	
}
