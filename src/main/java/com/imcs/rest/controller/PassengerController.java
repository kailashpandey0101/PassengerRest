package com.imcs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.passenger.respository.entity.Passenger;
import com.imcs.passenger.respository.services.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger) {
		boolean flag = passengerService.addPassenger(passenger);
		if (flag)
			return new ResponseEntity(HttpStatus.CREATED);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<?> getPassenger(@PathVariable("id") String id) {
		return new ResponseEntity(passengerService.getPassenger(id), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id) {
		if (passengerService.deletePassenger(id)) {
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody Passenger passenger) {
		boolean flag = passengerService.updatePassenger(passenger);
		if (flag) {
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}
