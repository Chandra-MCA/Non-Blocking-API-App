package com.anuj.reactivems;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anuj.reactivems.position.Position;
import com.anuj.reactivems.position.PositionRepository;

@Component
public class TestDataSetup {

	@Autowired
	private PositionRepository positionRepository;
	
	@PostConstruct
	public void setup(){
		System.out.println("----- Starting DataSetup :: setup -----");

		for(int i=0;i<100000;i++){
			final Position p1 = new Position(String.valueOf(i+1), "25-Apr-2020", "1001", "Buy");
			positionRepository.save(p1);
		}
		/*final Position p1 = new Position("1", "25-Apr-2020", "1001", "Buy");
		final Position p2 = new Position("2", "25-Apr-2020", "1001", "Sell");
		final Position p3 = new Position("3", "25-Apr-2020", "1001", "Buy");
		final Position p4 = new Position("4", "25-Apr-2020", "1001", "Sell");
		final Position p5 = new Position("5", "25-Apr-2020", "1001", "Buy");
		
		positionRepository.save(p1);
		positionRepository.save(p2);
		positionRepository.save(p3);
		positionRepository.save(p4);
		positionRepository.save(p5);*/
		
		System.out.println("----- Exit DataSetup :: setup -----");
	}
}
