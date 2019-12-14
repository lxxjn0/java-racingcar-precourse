/*
 * @(#)Input.java		0.1 2019.12.13
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.ui;

import java.util.Scanner;

/**
 * 입력과 관련된 모든 기능을 담당하는 Input 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.1 2019.12.13
 */
public class Input {
	private Scanner scanner;

	/**
	 * 사용자로부터 입력받은 자동차 이름을 반환.
	 *
	 * @return 입력받은 자동차 이름을 반환.
	 */
	public String receiveCarNamesInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	/**
	 * 사용자로부터 입력받은 시도 횟수를 반환.
	 *
	 * @return 입력받은 시도 횟수를 반환.
	 */
	public int receiveAttemptNumberInput() {
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
