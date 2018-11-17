package gov.smartagro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.smartagro.api.model.Crop;


@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

}
