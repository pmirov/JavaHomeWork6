package com.mirov.top.dao;

import com.mirov.top.entity.Car;
import com.mirov.top.entity.CarType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private static final String SELECT_ALL = "select * from cars";
    private static final String SELECT_MANUFACTURER = "select distinct manufacturer from cars";
    private static final String SELECT_AMOUNT = "select manufacturer, count(*) as amount from cars\n" +
                                               "group by  manufacturer;";
    private static final String CREATE_ITEM = "insert into cars (manufacturer, name, volume, creationDate, color, type) " +
                                                "values (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_ITEM = "delete from cars where id = ?";

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

    public List<Car> selectCarAmount() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars",
                "postgres", "root");
             Statement statement = connection.createStatement())

        {
            ResultSet resultSet = statement.executeQuery(SELECT_AMOUNT);
            while (resultSet.next()) {
                Car car = new Car();
                car.setManufacturer(resultSet.getString("manufacturer"));
                car.setAmount(resultSet.getInt("amount"));

                cars.add(car);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public void addCar(Car car) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars",
                "postgres", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ITEM))
        {
            preparedStatement.setString(1, car.getManufacturer());
            preparedStatement.setString(2, car.getName());
            preparedStatement.setFloat(3, car.getVolume());
            preparedStatement.setInt(4, car.getCreationDate());
            preparedStatement.setString(5, car.getColor());
            preparedStatement.setString(6, String.valueOf(car.getType()));
            preparedStatement.executeUpdate();
        }

         catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteCar(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars",
                "postgres", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ITEM))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
