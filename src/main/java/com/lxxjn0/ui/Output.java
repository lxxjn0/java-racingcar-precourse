/*
 * @(#)Output.java		0.2 2019.12.14
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.ui;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 출력과 관련된 기능을 담당하는 Output 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.2 2019.12.14
 */
public class Output {
	/**
	 * 자동차 이름을 입력받을 때 출력할 메시지 상수.
	 */
	private static final String CAR_NAMES_INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	/**
	 * 자동차 이름의 길이에 오류가 존재할 경우 출력할 메시지 상수.
	 */
	private static final String CAR_NAMES_LENGTH_ERROR_MESSAGE = "경주할 자동차 이름은 1자 이상, 5자 이하만 가능합니다. ";

	/**
	 * 자동차 이름의 형식에 오류가 존재할 경우 출력할 메시지 상수.
	 */
	private static final String CAR_NAMES_FORMAT_ERROR_MESSAGE = "경주할 자동차 이름은 공백을 제외한 영문자와 숫자의 조합으로만 가능합니다. ";

	/**
	 * 자동차 이름에 중복이 존재할 경우 출력할 메시지 상수.
	 */
	private static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "중복된 자동차 이름이 존재합니다. ";

	/**
	 * 시도 횟수를 입력받을 때 출력할 메시지 상수.
	 */
	private static final String ATTEMPT_NUMBER_INPUT_REQUEST_MESSAGE = "시도할 회수는 몇 회인가요?";

	/**
	 * 시도 횟수를 입력할 때 오류가 발생할 경우 출력할 메시지 상수.
	 */
	private static final String ATTEMPT_NUMBER_ERROR_MESSAGE = "시도 횟수가 0보다 큰 정수가 아닙니다. ";

	/**
	 * 재 입력을 요청할 때 출력할 메시지 상수.
	 */
	private static final String RE_ENTER_MESSAGE = "다시 입력해주세요.";

	/**
	 * N번째 Lap 실행 결과를 보여줄 때 출력할 메시지 상수.
	 */
	private static final String NTH_LAP_MOVE_RESULT_MESSAGE = " Lap 실행 결과";

	/**
	 * 모든 자동차 위치가 출발선에 위치할 경우 출력할 메시지 상수.
	 */
	private static final String NO_WINNER_EXIST_MESSAGE = "자동차들이 모두 출발선에 위치해 있습니다. 우승자가 존재하지 않습니다.";

	/**
	 * 최종 우승자들을 출력할 메시지 상수.
	 */
	private static final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

	/**
	 * 이름에 대한 위치 결과를 구분하기 위한 문자열 상수.
	 */
	private static final String COLON = " : ";

	/**
	 * 개행을 위한 문자열 상수.
	 */
	private static final String NEW_LINE = "\n";

	/**
	 * 자동차 이름을 입력 요청 메시지를 출력하는 메소드.
	 */
	public void printRequestCarNamesInput() {
		System.out.println(CAR_NAMES_INPUT_REQUEST_MESSAGE);
	}

	/**
	 * 자동차 이름의 길이에 오류가 존재한다는 메시지를 출력하는 메소드.
	 */
	public void printInputLengthError() {
		System.out.println(CAR_NAMES_LENGTH_ERROR_MESSAGE + RE_ENTER_MESSAGE);
	}

	/**
	 * 자동차 이름의 형식에 오류가 존재한다는 메시지를 출력하는 메소드.
	 */
	public void printInputFormatError() {
		System.out.println(CAR_NAMES_FORMAT_ERROR_MESSAGE + RE_ENTER_MESSAGE);
	}

	/**
	 * 자동차 이름의 중복 오류가 존재한다는 메시지를 출력하는 메소드.
	 */
	public void printInputDuplicateError() {
		System.out.println(CAR_NAMES_DUPLICATE_ERROR_MESSAGE + RE_ENTER_MESSAGE);
	}

	/**
	 * 시도 횟수 입력 요청 메시지를 출력하는 메소드.
	 */
	public void printRequestAttemptNumberInput() {
		System.out.println(ATTEMPT_NUMBER_INPUT_REQUEST_MESSAGE);
	}

	/**
	 * 시도 횟수의 입력에 오류가 존재한다는 메시지를 출력하는 메소드.
	 */
	public void printAttemptNumberInputError() {
		System.out.println(ATTEMPT_NUMBER_ERROR_MESSAGE + RE_ENTER_MESSAGE);
	}

	/**
	 * N번째 시도(lap)의 결과 메시지를 출력하는 메소드.
	 * @param LapNumber lap 번호.
	 */
	public void printNthLapMoveResult(int LapNumber) {
		System.out.println(NEW_LINE + LapNumber + NTH_LAP_MOVE_RESULT_MESSAGE);
	}

	/**
	 * 각 자동차 별로 이동 결과를 출력하는 메소드.
	 *
	 * @param carName 이동 결과를 출력할 자동차의 이름.
	 * @param moveBar 해당 자동차의 이동 결과.
	 */
	public void printCarMoveResult(String carName, String moveBar) {
		System.out.println(carName + COLON + moveBar);
	}

	/**
	 * 우승자가 존재하지 않는다는 메시지를 출력하는 메소드.
	 */
	public void printNoWinnerExist() {
		System.out.println(NEW_LINE + NO_WINNER_EXIST_MESSAGE);
	}

	public void printWinnerResult(String winners) {
		System.out.println(NEW_LINE + winners + WINNER_RESULT_MESSAGE);
	}
}
