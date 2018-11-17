package gov.smartagro.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.smartagro.api.model.UserCrop;


@Repository
public interface UserCropRepository extends JpaRepository<UserCrop, Long> {

//	@Query("SELECT u UserCrop u where userid= order by createddate")
//	Optional<UserCrop> findCurrentCropOfUser(Long userId);

	List<UserCrop> findByUserid(Long id);

	List<UserCrop> findByUseridOrderByUsercropidDesc(Long id);
}
