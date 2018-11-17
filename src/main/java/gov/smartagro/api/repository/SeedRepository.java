package gov.smartagro.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.smartagro.api.model.Seed;


@Repository
public interface SeedRepository extends JpaRepository<Seed, Long> {

	List<Seed> findByCropid(Long cropId);

}
