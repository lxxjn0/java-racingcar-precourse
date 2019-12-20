/*
 * @(#)Cars.java		0.1 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0
 */

package com.lxxjn0.domain;

import java.util.Collections;
import java.util.List;

import com.lxxjn0.ui.Output;

public class Cars {
	private final List<Car> cars;

	public Cars(String carNames) {
		cars = CarFactory.generateCars(carNames);

		isDuplicate(cars);
	}

	private void isDuplicate(List<Car> cars) {
		if (cars.size() != cars.stream().distinct().count()) {
			throw new IllegalArgumentException(Output.CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE);
		}
	}

	public List<Car> moveCars(RandomNumberStrategy moveStrategy) {
		cars.forEach(car -> car.moveCar(moveStrategy));
		return Collections.unmodifiableList(cars);
	}
}
