package gov.smartagro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.smartagro.api.model.Soiltocrop;


@Repository
public interface SoilCropRepository extends JpaRepository<Soiltocrop, Long> {


}
