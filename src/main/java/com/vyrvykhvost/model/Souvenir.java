package com.vyrvykhvost.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Souvenir extends Manufacturer {
    private String name;
    private int day;
    private int month;
    private int year;
    private double price;

    public Souvenir(String manufacturerCountry, String manufacturerName, String name, int day, int month, int year, double price) {
        super(manufacturerCountry, manufacturerName);
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.price = price;
    }

    public static Souvenir convert(String s) {
        String[] arr;
        arr = s.split(",");
        return new Souvenir(arr[0],
                arr[1],
                arr[2],
                Integer.parseInt(arr[3]),
                Integer.parseInt(arr[4]),
                Integer.parseInt(arr[5]),
                Double.parseDouble(arr[6]));
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "Country= " + super.getManufacturerCountry() +
                ", Company= " + super.getManufacturerName() +
                ", name= " + name  +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", price=" + price +
                '}';
    }


    public String toStringSouvenir() {
        return "Souvenir{" +
                "name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
