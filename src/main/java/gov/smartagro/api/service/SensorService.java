package gov.smartagro.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.smartagro.api.model.Sensordata;
import gov.smartagro.api.repository.SensorRepository;

@Service
public class SensorService {

	@Autowired
	private SensorRepository sensorRepository;

	private static final Logger logger = LoggerFactory.getLogger(SensorService.class);

	public Sensordata saveSensorData(Sensordata data) {

		try {

			data = sensorRepository.save(data);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return data;
	}

	public List<Sensordata> getSensorData(Integer userId) {
		
		return sensorRepository.findAllByOrderBySensordataidDesc();
	}


}
