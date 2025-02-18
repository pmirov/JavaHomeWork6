package com.mirov.top;
import com.mirov.top.entity.Car;
import com.mirov.top.service.CarService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        var cars = carService.findAll();

        for (Car car : cars) {
            System.out.println(car);
        }
        var manufacturer = carService.findManufacturer();

        for (Car car : manufacturer) {
            System.out.println(car.getManufacturer());
        }

       var carAmount = carService.findCarAmount();

        for (Car car : carAmount) {
            System.out.println(car.getManufacturer() + " " + car.getAmount());

        }
        carAmount.sort(Comparator.comparing(Car::getAmount).reversed());

        System.out.println(carAmount.getFirst().getManufacturer() + " " + carAmount.getFirst().getAmount());

        System.out.println(carAmount.getLast().getManufacturer() + " " + carAmount.getLast().getAmount());




    }
}