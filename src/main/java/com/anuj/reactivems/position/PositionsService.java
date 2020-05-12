package com.anuj.reactivems.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PositionsService {

	@Autowired
	private PositionRepository positionRepository;
	
	public Mono<Position> getPosition(String positionId){
		final Mono<Position> position = Mono.fromCallable(() -> positionRepository.findById(positionId).get());
		return position;
	}

	public Flux<Position> getAllPositions(){

		final Flux<Position> defer = Flux.defer(() -> Flux.fromIterable(positionRepository.findAll()));
		//defer.blockFirst();
		return defer;
	}
	
	/*public Flux<Position> getAllPositions_2(){

		final Flux<Position> defer = Flux.fromIterable(() -> Flux.fromIterable(positionRepository.findAll()));
		//defer.blockFirst();
		return defer;
	}
	
	public Flux<Position> getAllPositions_3(){

		final Flux<Position> defer = Flux.defer(() -> Flux.fromIterable(positionRepository.findAll()));
		//defer.blockFirst();
		return defer;
	}
	
	public Flux<Position> getAllPositions_4(){

		final Flux<Position> defer = Flux.defer(() -> Flux.fromIterable(positionRepository.findAll()));
		//defer.blockFirst();
		return defer;
	}
	
	public Flux<Position> getAllPositions_5(){

		final Flux<Position> defer = Flux.defer(() -> Flux.fromIterable(positionRepository.findAll()));
		//defer.blockFirst();
		return defer;
	}*/
	
	
	public Flux<Position> getAllPositionsForACustomer(String customerId){

		Flux<Position> defer = Flux.defer(() -> Flux.fromIterable(positionRepository.findAll()));
		//return defer.subscribeOn(jdbcScheduler);
		return defer;
		
		/*final List<Position> positions = positionRepository.findAll();
		
		return Flux.fromIterable(positions);*/
	}

	public List<Position> filterPositionsForADate(List<Position> positions, String positionDate){

		return null;
	}

	public List<Position> filterPositionsBetweenStartEndDates(List<Position> positions, String positionDate){

		return null;
	}
}
