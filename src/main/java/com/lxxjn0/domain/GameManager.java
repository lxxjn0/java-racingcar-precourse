/*
 * @(#)GameManager.java		0.2 2019.12.14
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.domain;

import java.util.InputMismatchException;
import java.util.List;

import com.lxxjn0.ui.Input;
import com.lxxjn0.ui.Output;

/**
 * 게임의 진행을 관리하는 GameManager 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.2 2019.12.14
 */
public class GameManager {
	/**
	 * 입력과 관련된 일을 담당할 Input 인스턴스.
	 */
	private Input in = new Input();

	/**
	 * 출력과 관련된 일을 담당할 Output 인스턴스.
	 */
	private Output out = new Output();

	/**
	 * 자동차 경주 게임이 이뤄지는 RacingGame 인스턴스.
	 */
	private RacingGame racingGame;

	/**
	 * 자동차 이름을 받아서 자동차 경주 게임을 만들고 시도 횟수만큼 시도해 우승자를 출력하는 전체적인 진행 메소드.
	 */
	public void run() {
		racingGame = new RacingGame(receiveCarNames());
		moveForAttemptNumber(receiveAttemptNumber());
		racingGame.printRaceWinner();
	}

	/**
	 * 입력받은 시도 횟수만큼 이동하면서, 매 번 실행 결과를 출력하는 메소드.
	 *
	 * @param attemptNumber 사용자로부터 입력받은 시도 횟수.
	 */
	private void moveForAttemptNumber(int attemptNumber) {
		for (int lap = 0; lap < attemptNumber; lap++) {
			racingGame.runRacingGameOnce(lap);
		}
	}

	/**
	 * 자동차의 이름을 입력받아 유효성을 검사 후, 유효하다면 carNames 문자열 리스트에 저장하는 메소드.
	 *
	 * @return 유효성이 검증된 자동차 이름들을 쉼표(,)를 기준으로 나눠서 List 반환.
	 */
	private List<String> receiveCarNames() {
		List<String> carNames;

		try {
			out.printRequestCarNamesInput();

			carNames = StringUtil.splitCarNames(in.receiveCarNamesInput());
			StringUtil.trimCarNames(carNames);

			Validator validator = new Validator(carNames);
			validator.isValidInput();
		} catch (InputMismatchException e) {
			return receiveCarNames();
		}
		return carNames;
	}

	/**
	 * 사용자로부터 시도 횟수를 입력받고, 유효한지 여부도 확인하는 메소드.
	 *
	 * @return 사용자로부터 입력받은 시도 횟수 반환.
	 */
	private int receiveAttemptNumber() {
		int attemptNumber;

		try {
			out.printRequestAttemptNumberInput();
			attemptNumber = in.receiveAttemptNumberInput();

			Validator validator = new Validator(attemptNumber);
			validator.isValidAttemptNumber();
		} catch (InputMismatchException e) {
			out.printAttemptNumberInputError();
			out.printRequestAttemptNumberInput();
			return receiveAttemptNumber();
		}
		return attemptNumber;
	}
}
