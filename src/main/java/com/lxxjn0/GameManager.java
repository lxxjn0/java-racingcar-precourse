/*
 * @(#)GameManager.java		0.3 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0;

import com.lxxjn0.domain.Cars;
import com.lxxjn0.domain.RaceResult;
import com.lxxjn0.domain.RandomNumberStrategy;
import com.lxxjn0.ui.Input;
import com.lxxjn0.ui.Output;

/**
 * 게임의 진행을 관리하는 GameManager 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.3 2019.12.20
 */
public class GameManager {
	public void run() {
		RandomNumberStrategy moveStrategy = new RandomNumberStrategy();
		RacingGame racingGame = new RacingGame(moveStrategy);

		Cars cars = receiveCarNames(racingGame);
		RaceResult raceResult = receiveAttemptInput(racingGame, cars);

		Output.printRaceResult(raceResult);
		Output.printRaceWinner(raceResult);
	}

	public Cars receiveCarNames(RacingGame racingGame) {
		try {
			String carNames = Input.receiveCarNamesInput();
			return racingGame.generateCars(carNames);
		} catch (IllegalArgumentException e) {
			Output.printExceptionMessage(e.getMessage());
			return receiveCarNames(racingGame);
		}
	}

	public RaceResult receiveAttemptInput(RacingGame racingGame, Cars cars) {
		try {
			String AttemptInput = Input.receiveAttemptNumberInput();
			return racingGame.startRace(AttemptInput, cars);
		} catch (IllegalArgumentException e) {
			Output.printExceptionMessage(e.getMessage());
			return receiveAttemptInput(racingGame, cars);
		}
	}
}
