package com.mirov.top;
import com.mirov.top.entity.Car;
import com.mirov.top.entity.CarType;
import com.mirov.top.service.CarService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();

        //Вывод всех автомобилей
        carService.printAllCars();

        //Вывод всех производителей
        carService.printManufacturers();

        //Вывод количество автомобилей определенного производителя
        carService.printCarAmounts();

        //Вывод наибольшего и наименьшего количества автомобилей
        carService.printMaxAndMinAmount();

        //Вывод автомобилей по конкретному году выпуска
          Scanner sc = new Scanner(System.in);
//        System.out.println("Введите год выпуска автомобиля:");
//        int carYear = sc.nextInt();
//        carService.printCarsByYear(carYear);

        //Вывод автомобилей по диапазону года выпуска
//        System.out.println("Введите начальный диапазон года выпуска автомобиля:");
//        int startCarYear = sc.nextInt();
//        System.out.println("Введите конечный диапазон года выпуска автомобиля:");
//        int finalCarYear = sc.nextInt();
//        carService.printCarsByYearRange(startCarYear,finalCarYear);

        //Вывод автомобилей по конкретному производителю
//        System.out.println("Введите производителя автомобиля:");
//        String manufacturer = sc.next();
//        carService.printCarsByManufacture(manufacturer);

        //Фильтр для отображения автомобилей по указанному цвету
//        System.out.println("Введите цвет автомобиля:");
//        String colorCar = sc.next();
//        carService.printCarsByColor(colorCar);

        //Фильтр для отображения автомобилей по объему двигателя
//        System.out.println("Введите объем двигателя автомобиля:");
//        int volume = sc.nextInt();
//        carService.printCarsByVolume(volume);

        //Фильтр для отображения автомобилей по типу кузова
        System.out.println("Введите тип кузова автомобиля:");
        CarType carType = CarType.valueOf(sc.next());
        carService.printCarsByType(carType);

    }
}