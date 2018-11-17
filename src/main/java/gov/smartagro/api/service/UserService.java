package gov.smartagro.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.smartagro.api.model.User;
import gov.smartagro.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(SensorService.class);
	

	public void updatePassword(String updatedPassword, Long id) {
		User user = userRepository.findById(id).get();
		user.setPassword(updatedPassword);
		userRepository.save(user);
	}
	
}
