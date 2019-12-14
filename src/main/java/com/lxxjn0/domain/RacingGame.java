/*
 * @(#)RacingGame.java     1.4 2019.12.14
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.domain;

import java.util.ArrayList;
import java.util.List;

import com.lxxjn0.ui.Input;
import com.lxxjn0.ui.Output;

/**
 * 사용자로부터 자동차의 이름을 입력받고 게임을 진행 후 우승자를 출력하는 전반적인 진행을 담당하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 1.4 2019.12.14
 */
public class RacingGame {
	/**
	 * 출력과 관련된 일을 담당할 Output 인스턴스.
	 */
	private Output out = new Output();

	/**
	 * 생성한 Car 클래스의 객체들을 저장할 List 변수.
	 */
	private List<Car> cars;

	/**
	 * 자동차 이름들을 매개변수로 받아서 자동차를 생성하는 매개변수 생성자.
	 *
	 * @param carNames 자동차 이름이 저장된 List.
	 */
	public RacingGame(List<String> carNames) {
		generateCarInstances(carNames);
	}

	/**
	 * 유효함이 검증된 자동차의 이름으로 Car 클래스 객체를 생성하는 메소드.
	 *
	 * @param carNames 자동차의 이름이 저장된 String list.
	 */
	private void generateCarInstances(List<String> carNames) {
		cars = new ArrayList<>();

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	/**
	 * RacingGame을 한 번 진행하는 메소드.
	 *
	 * @param lap lap의 번호.
	 */
	public void runRacingGameOnce(int lap) {
		out.printNthLapMoveResult(lap);
		for (Car car : cars) {
			car.raceGameOnce();
		}
	}

	/**
	 * 우승한 자동차들의 이름을 반환하는 메소드.
	 */
	public void printRaceWinner() {
		if (Car.isNoWinnerExist()) {
			out.printNoWinnerExist();
			return;
		}
		out.printWinnerResult(StringUtil.joinWinnerNames(selectRaceWinner()));
	}

	/**
	 * Car 클래스에 저장된 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)과 위치가 동일한 자동차들을 반환하는 메소드.
	 *
	 * @return 우승한 자동차 이름 List 반환.
	 */
	private List<String> selectRaceWinner() {
		List<String> winners = new ArrayList<>();

		for (Car car : cars) {
			if (car.isWinner()) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}
