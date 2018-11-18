package gov.smartagro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import gov.smartagro.api.model.Soilhealthcard;


@Repository
public interface SoilHealthRepository extends JpaRepository<Soilhealthcard, Long> {

	Optional<Soilhealthcard> findByCardnumber(Long id);


	
}
