package com.company;

import java.util.Comparator;

public class Toy {
    private int number;
    private String name;
    private double price;
    private int age;

    public Toy(){
        number = 0;
        name = "";
        price = 0.0;
        age = 0;
    }

    public Toy(int number, String name, double price, int age){
        this.number = number;
        this.name=name;
        this.price=price;
        this.age=age;
    }

//    public boolean isToysForYou(int age){
//        if(age>=this.age){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Comparator<Toy> getAgeComp(){
        return Comparator.comparingInt(a -> a.age);
    }

    public static Comparator<Toy> getPriceComp(){
        return Comparator.comparingDouble(a -> a.price);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", age=" + age +
                '}';
    }
}
