package com.howtodoinjava.service;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import com.howtodoinjava.model.order.Company;
import com.howtodoinjava.model.order.ContactPerson;
import com.howtodoinjava.model.order.Order;
import com.howtodoinjava.repositories.order.OrderRepository;*/
import com.howtodoinjava.model.user.User;
import com.howtodoinjava.repositories.user.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MultiDataSourceService {
	private final UserRepository userRepository;
//	private final OrderRepository orderRepository;

	@Autowired
	public MultiDataSourceService(UserRepository userRepository) {
		this.userRepository = userRepository;
//		this.orderRepository = orderRepository;
	}

	public User saveToH2Db(User user) {
		User savedUser = userRepository.save(user);
		log.info("user saved successfully in h2 database");
		return savedUser;
	}

	/*public Order saveToPostGres(Order order) {
		Order savedOrder = orderRepository.save(order);
		log.info("order saved successfully in postgres database");
		return savedOrder;
	}*/

	/*public void saveCompany() {
		ContactPerson contactPerson = ContactPerson.builder().firstName("Ashok").lastName("Behera").phone("9848022338")
				.build();
		HashMap<String, String> clientNames = new HashMap<>();
		clientNames.put("KP", "USA"); clientNames.put("CC", "USA"); clientNames.put("LinkedIn", "North Corea");

		Company companyToSave = Company.builder().name("Cognizant").contactPerson(contactPerson)
				.branches(Arrays.asList("Chennai", "Bhubaneswar", "Bangalore")).clientNameLangMap(clientNames).build();

		log.info("company save response : " + companyToSave);
	}*/
}
