package com.mirov.top.entity;

public class Car
{
    private int id;
    private CarType type;
    private String manufacturer;
    private String name;
    private float volume;
    private int creationDate;
    private String color;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "id :" + id +
                ", производитель: " + manufacturer +
                ", марка: " + name +
                ", объем двигателя: " + volume +
                ", дата выпуска: " + creationDate +
                ", цвет: " + color +
                ", тип кузова: " + type;
    }

//    @Override
//    public int compareTo(Car o1, Car o2) {
//        return o1.getAmount() - o2.getAmount();
//    }
}
