package com.mirov.top.dao;

import com.mirov.top.entity.Car;
import com.mirov.top.entity.CarType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private static final String SELECT_ALL = "select * from cars";
    private static final String SELECT_MANUFACTURER = "select distinct manufacturer from cars";

    public List<Car> selectAll() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars",
                "postgres", "root");
             Statement statement = connection.createStatement())

        {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setManufacturer(resultSet.getString("manufacturer"));
                car.setName(resultSet.getString("name"));
                car.setVolume(resultSet.getFloat("volume"));
                car.setCreationDate(resultSet.getInt("creationDate"));
                car.setColor(resultSet.getString("color"));
                car.setType(CarType.valueOf(resultSet.getString("type")));
                cars.add(car);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public List<Car> selectManufacturer() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars",
                "postgres", "root");
             Statement statement = connection.createStatement())

        {
            ResultSet resultSet = statement.executeQuery(SELECT_MANUFACTURER);
            while (resultSet.next()) {
                Car car = new Car();
                car.setManufacturer(resultSet.getString("manufacturer"));
                cars.add(car);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

}
