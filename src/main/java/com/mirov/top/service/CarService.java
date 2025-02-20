package com.mirov.top.service;

import com.mirov.top.dao.CarDao;
import com.mirov.top.entity.Car;

import java.util.*;

public class CarService {
    private CarDao carDao = new CarDao();

    public List<Car> findAll()
    {
        return carDao.selectAll();
    }

    public List<Car> findManufacturer()
    {
        return carDao.selectManufacturer();
    }
    public List<Car> findCarAmount()
    {
        return carDao.selectCarAmount();
    }

    public void printAllCars()
    {
        List<Car> cars = carDao.selectAll();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void printManufacturers()
    {
        List<Car> manufacturers = findManufacturer();
        for (Car car : manufacturers) {
            System.out.println(car.getManufacturer());
        }
    }

    public void printCarAmounts()
    {
        List<Car> carAmount = findCarAmount();
        for (Car car : carAmount) {
            System.out.println(car.getManufacturer() + " " + car.getAmount());
        }
    }

    public void printMaxAndMinAmount()
    {
        List<Car> carAmount = findCarAmount();
        if(!carAmount.isEmpty())
        {
            carAmount.sort(Comparator.comparing(Car::getAmount).reversed());
             System.out.println("Наибольшее количество: " + carAmount.getFirst().getManufacturer() + " " + carAmount.getFirst().getAmount());
             System.out.println("Наименьшее количество: " + carAmount.getLast().getManufacturer() + " " + carAmount.getLast().getAmount());
        }
    }

    public void printCarsByYear(int year)
    {
        boolean checkYear = false;
        List<Car> cars = findAll();
        for (Car car : cars) {
            if(year == car.getCreationDate())
            {
                System.out.println(car.getManufacturer() + " " + car.getName());
                checkYear = true;
            }
        }
        if (!checkYear) {
            System.out.println("Машин такого года выпуска нет!");
        }
    }
    public void printCarsByYearRange(int startYear, int endYear)
    {
        boolean checkYear = false;
        List<Car> cars = findAll();
        for (Car car : cars) {
            if(car.getCreationDate() >= startYear && car.getCreationDate() <= endYear)
            {
                System.out.println(car.getManufacturer() + " " + car.getName() + " " + car.getCreationDate());
                checkYear = true;
            }
        }
        if (!checkYear) {
            System.out.println("Машин в таком диапазоне года выпуска нет!");
        }
    }

    public void printCarsByManufacture(String manufacturer)
    {
        boolean checkCar = false;
        List<Car> cars = findAll();
        for (Car car : cars) {
            if(car.getManufacturer().equals(manufacturer))
            {
                System.out.println(car.getName());
                checkCar = true;
            }
        }
        if (!checkCar) {
            System.out.println("Машин такого производителя нет!");
        }
    }

    public void printCarsByColor(String color)
    {
        List<Car> cars = findAll();
//        List<String> colorList = new ArrayList<String>();
//        System.out.println("Выберите из предложенных цветов автомобиля: ");
//        for (Car car : cars) {
//
//            colorList.add(car.getColor());
//
//        }
//        Set<String> set = new HashSet<>(colorList);
//        colorList.clear();
//        colorList.addAll(set);
//        for (String col : colorList) {
//
//            if(Objects.equals(col, colorList.getLast()))
//            {
//                System.out.println(col);
//            }
//            else
//            {
//                System.out.print(col + ", ");
//
//            }
//
//        }
        boolean checkCar = false;

        for (Car car : cars) {
            if(car.getColor().equals(color))
            {
                System.out.println(car.getManufacturer() + " " + car.getName() + " " + car.getColor());
                checkCar = true;
            }
        }
        if (!checkCar) {
            System.out.println("Машин такого цвета нет!");
        }

    }
    public void printCarsByVolume(float volume)
    {
        boolean checkCar = false;
        List<Car> cars = findAll();
        for (Car car : cars) {
            if(car.getVolume() == volume)
            {
                System.out.println(car.getManufacturer() + " " + car.getName() + ", объем двигателя: " + + car.getVolume());
                checkCar = true;
            }
        }
        if (!checkCar) {
            System.out.println("Машин с таким объемом двигателя нет!");
        }
    }


}

