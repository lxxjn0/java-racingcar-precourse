/*
 * @(#)CarFactory.java		0.1 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0
 */

package com.lxxjn0.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarFactory {
	public static List<Car> generateCars(String userInput) {
		return Pattern.compile(",")
			.splitAsStream(userInput)
			.map(String::trim)
			.map(CarFactory::generateCar)
			.collect(Collectors.toList());
	}

	private static Car generateCar(String carName) {
		return new Car(new Name(carName));
	}
}
