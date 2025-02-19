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

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год выпуска автомобиля:");
        int carYear = sc.nextInt();
        boolean checkYear = false;
        for (Car car : cars) {
           if(carYear == car.getCreationDate())
            {
                System.out.println(car.getManufacturer() + " " + car.getName());
                checkYear = true;
            }
        }
        if (!checkYear) {
            System.out.println("Машин такого года выпуска нет!");
        }

        System.out.println("Введите начальный диапазон года выпуска автомобиля:");
        int startCarYear = sc.nextInt();
        System.out.println("Введите конечный диапазон года выпуска автомобиля:");
        int finalCarYear = sc.nextInt();
        checkYear = false;
        for (Car car : cars) {
            if(car.getCreationDate() >= startCarYear && car.getCreationDate() <= finalCarYear)
            {
                System.out.println(car.getManufacturer() + " " + car.getName());
                checkYear = true;
            }
        }
        if (!checkYear) {
            System.out.println("Машин в таком диапазоне года выпуска нет!");
        }



    }
}