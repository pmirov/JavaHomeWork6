package com.mirov.top.dao;

import com.mirov.top.entity.Car;
import com.mirov.top.entity.CarType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private static final String SELECT_ALL = "select * from cars";
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
                car.setType(CarType.valueOf(resultSet.getString("type")));
                cars.add(car);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

}
