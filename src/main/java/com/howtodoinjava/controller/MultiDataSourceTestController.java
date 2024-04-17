package com.howtodoinjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.config.YamlPropertyReadConfig;
import com.howtodoinjava.model.user.User;
/*import com.howtodoinjava.model.order.Order;
import com.howtodoinjava.repositories.order.CompanyRepository;
import com.howtodoinjava.repositories.order.OrderRepository;*/
import com.howtodoinjava.repositories.user.UserRepository;
import com.howtodoinjava.service.MultiDataSourceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MultiDataSourceTestController {

//	@Autowired
//	CompanyRepository companyRepository;
	
	@Autowired
	YamlPropertyReadConfig yamlPropertyReadConfig;

	private final MultiDataSourceService multiDataSourceService;

	private final UserRepository userRepository;
//	private final OrderRepository orderRepository;

	@Autowired
	public MultiDataSourceTestController(MultiDataSourceService multiDataSourceService, UserRepository userRepository) {
		this.multiDataSourceService = multiDataSourceService;
		this.userRepository = userRepository;
//		this.orderRepository = orderRepository;
	}

	@RequestMapping("/saveToH2")
	public User saveToH2Db(@RequestBody User user) {
		String methodName = "saveToH2Db";
		log.info("start of " + methodName);
		log.info("user request {}", user);
		User savedResponse = multiDataSourceService.saveToH2Db(user);
		log.info("end of " + methodName);
		return savedResponse;
	}

	/*
	 * @RequestMapping("/saveToPostgres") public Order saveToPostgres(@RequestBody
	 * Order order) { String methodName = "saveToPostgres"; log.info("start of " +
	 * methodName); log.info("user request {}", order); Order savedResponse =
	 * multiDataSourceService.saveToPostGres(order); log.info("end of " +
	 * methodName); return savedResponse; }
	 */

	@GetMapping("/")
	public ResponseEntity<?> indexPage() {

//		multiDataSourceService.saveCompany();
		
		if(null!=yamlPropertyReadConfig)
			System.out.println(yamlPropertyReadConfig.getDatabases());

		if (userRepository.findAll().size() != 0)
			return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
		else if (userRepository.findAll().size() != 0)
			return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
		else
			return new ResponseEntity<>("Multi Data Source", HttpStatus.OK);
	}

}
