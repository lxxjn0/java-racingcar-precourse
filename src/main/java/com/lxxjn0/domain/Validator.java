/*
 * @(#)Validator.java		0.2 2019.12.14
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.domain;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;

import com.lxxjn0.ui.Output;

/**
 * 입력의 유효성을 판단하는 메소드들을 구현한 Validator 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.2 2019.12.14
 */
public class Validator {
	/**
	 * 시도 횟수가 1 이상의 정수인지 확인하기 위한 상수.
	 */
	private static final int MIN_ATTEMPT_NUMBER = 1;

	/**
	 * 자동차 이름의 최소 길이 조건에 만족하는지 확인하기 위한 상수.
	 */
	private static final int MIN_LEN_OF_CAR_NAME = 1;

	/**
	 * 자동차 이름의 최대 길이 조건에 만족하는지 확인하기 위한 상수.
	 */
	private static final int MAX_LEN_OF_CAR_NAME = 5;

	/**
	 * 자동차의 이름이 영문자 또는 숫자로만 이루어져 있는지 확인하기 위한 정규식 상수.
	 */
	private static final String CAR_NAME_FORMAT = "^[a-zA-Z0-9]*$";

	/**
	 * 출력과 관련된 기능을 담당할 Output 인스턴스.
	 */
	private Output out = new Output();

	/**
	 * 유효성 검증을 할 자동차 이름 변수.
	 */
	private List<String> carNames;

	/**
	 * 유효성 검증을 할 시도 횟수 변수.
	 */
	private int attemptNumber;

	/**
	 * 자동차 이름에 대한 유효성 검증을 진행할 때 사용될 매개변수 생성자.
	 *
	 * @param carNames 자동차 이름의 List.
	 */
	public Validator(List<String> carNames) {
		this.carNames = carNames;
	}

	/**
	 * 시도 횟수에 대한 유효성 검증을 진행할 때 사용될 매개변수 생성자.
	 *
	 * @param attemptNumber 사용자로부터 입력받은 시도 횟수.
	 */
	public Validator(int attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	/**
	 * 입력된 자동차 이름이 유효하지 않을 경우 예외를 발생시키는 메소드.
	 *
	 * @throws InputMismatchException 자동차 이름이 유효성 검증을 통과하지 못하였을 경우 발생하는 예외.
	 */
	public void isValidInput() throws InputMismatchException {
		try {
			isValidLength();
			isValidFormat();
			isNoDuplication();
		} catch (InputMismatchException e) {
			out.printRequestReEnter();
			throw new InputMismatchException();
		}
	}

	/**
	 * 모든 자동차의 이름이 1자 이상 5자 이하가 아닐 경우 예외를 발생시키는 메소드.
	 *
	 * @throws InputMismatchException 자동차 이름의 길이가 유효하지 않을 경우 발생하는 예외.
	 */
	private void isValidLength() throws InputMismatchException {
		for (String car : carNames) {
			if ((car.length() < MIN_LEN_OF_CAR_NAME) || (car.length() > MAX_LEN_OF_CAR_NAME)) {
				out.printInputLengthError();
				throw new InputMismatchException();
			}
		}
	}

	/**
	 * 모든 자동차의 이름의 형식(공백이 존재하지 않는 숫자 혹은 영문자로 구성)이 유효하지 않을 경우 예외를 발생시키는 메소드.
	 *
	 * @throws InputMismatchException 자동차 이름의 형식이 유효하지 않을 경우 발생하는 예외.
	 */
	private void isValidFormat() throws InputMismatchException {
		for (String car : carNames) {
			if (!Pattern.matches(CAR_NAME_FORMAT, car)) {
				out.printInputFormatError();
				throw new InputMismatchException();
			}
		}
	}

	/**
	 * 동일한 자동차 이름이 중복되어 존재할 경우 예외를 발생시키는 메소드.
	 *
	 * @throws InputMismatchException 자동차 이름의 중복이 존재할 경우 발생하는 예외.
	 */
	private void isNoDuplication() throws InputMismatchException {
		HashSet<String> removedDuplicateCarNames = new HashSet<>(carNames);
		if (removedDuplicateCarNames.size() != carNames.size()) {
			out.printInputDuplicateError();
			throw new InputMismatchException();
		}
	}

	/**
	 * 입력이 정수로 확인된 이후, 해당 정수가 1 이상인지 확인하는 메소드.
	 *
	 * @throws InputMismatchException 1 이상의 정수가 아니라면 예외 발생.
	 */
	public void isValidAttemptNumber() throws InputMismatchException {
		if (!(attemptNumber >= MIN_ATTEMPT_NUMBER)) {
			throw new InputMismatchException();
		}
	}
}
