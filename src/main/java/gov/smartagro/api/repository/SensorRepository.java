package gov.smartagro.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.smartagro.api.model.Sensordata;


@Repository
public interface SensorRepository extends JpaRepository<Sensordata, Long> {


	List<Sensordata> findAllByOrderBySensordataidDesc();

	
}
