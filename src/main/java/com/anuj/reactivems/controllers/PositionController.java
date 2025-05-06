package com.anuj.reactivems.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.reactivems.position.Position;
import com.anuj.reactivems.position.PositionsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/positions")
public class PositionController {
	// starts here

	@PostConstruct
	public void start(){
		System.out.println("-- loading PositionController --");
	}
	
	@Autowired
	private PositionsService service;


	@GetMapping(path="/positionid", produces = "application/json")
	public ResponseEntity<Mono<Position>> getPositionForPositionId(@RequestParam(name = "positionId") String positionId){
		
		System.out.println("---------Method entry PositionController :: getPositionForPositionId---------");
		return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getPosition(positionId));
	}
	
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<Flux<Position>> getAllPositions()
	{
		System.out.println("---------Method entry PositionController :: getPositionForPositionId---------");
		
		return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getAllPositions());
	}
	
	
	@GetMapping(path="/customerid", produces = "application/json")
	public ResponseEntity<Flux<Position>> getPositionsForCustomerId(@RequestParam(name = "customerId") String customerId)
	{
		System.out.println("---------Method entry PositionController :: getPositionForPositionId---------");
		
		return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getAllPositionsForACustomer(customerId));
	}

	@GetMapping(path="/date", produces = "application/json")
	public Flux<Position> getPositionsForACustomerForABusinessDate(@RequestParam(name = "customerId") String customerId , 
			@RequestParam(name = "positionDate") String positionDate) 
	{
		return null;
	}

	@GetMapping(path="/betweendates", produces = "application/json")
	public Flux<Position> getPositionsBetweenTwoDates(@RequestParam(name = "customerId") String customerId , 
			@RequestParam(name = "positionStartDate") String positionStartDate,
			@RequestParam(name = "positionEndDate") String positionEndDate) 
	{
		return null;
	}
}
