/*
 * @(#)RacingGame.java     1.5 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0;

import java.util.List;

import com.lxxjn0.domain.AttemptNumber;
import com.lxxjn0.domain.Car;
import com.lxxjn0.domain.Cars;
import com.lxxjn0.domain.RaceResult;
import com.lxxjn0.domain.RaceStatus;
import com.lxxjn0.domain.RandomNumberStrategy;

public class RacingGame {
	RandomNumberStrategy moveStrategy;

	public RacingGame(RandomNumberStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}

	public Cars generateCars(String carNames) {
		return new Cars(carNames);
	}

	public RaceResult startRace(String inputNumber, Cars cars) {
		AttemptNumber attemptNumber = new AttemptNumber(inputNumber);

		RaceResult raceResult = new RaceResult();
		for (int i = 0; i < attemptNumber.getAttemptNumber(); i++) {
			final List<Car> raceCars = cars.moveCars(moveStrategy);
			raceResult.add(new RaceStatus(raceCars));
		}
		return raceResult;
	}
}
