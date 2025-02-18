package com.mirov.top.service;

import com.mirov.top.dao.CarDao;
import com.mirov.top.entity.Car;

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
}

