package com.mirov.top.service;

import com.mirov.top.dao.CarDao;
import com.mirov.top.entity.Car;

import java.util.Comparator;
import java.util.List;

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


}

