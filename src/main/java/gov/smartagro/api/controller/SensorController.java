package gov.smartagro.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gov.smartagro.api.model.Sensordata;
import gov.smartagro.api.response.SingleResponse;
import gov.smartagro.api.service.SensorService;

@RestController
public class SensorController {

	@Autowired
	private SensorService sensorService;

	private static final Logger logger = LoggerFactory.getLogger(SensorController.class);

	@PostMapping("sensor")
	public SingleResponse<Sensordata> saveSensorData(@RequestBody Sensordata data) {
		SingleResponse<Sensordata> resp = new SingleResponse<>();
		try {

			data = sensorService.saveSensorData(data);

		} catch (Exception e) {
			logger.error(e.getMessage());
			resp.setSuccess(true);
			return resp;
		}
		resp.setData(data);
		resp.setSuccess(true);
		return resp;
	}

}
