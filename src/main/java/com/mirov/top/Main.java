package com.mirov.top;

import com.mirov.top.entity.Car;
import com.mirov.top.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        var cars = carService.findAll();

        for (Car car : cars) {
            System.out.println(car);
        }

    }
}