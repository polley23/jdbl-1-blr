package org.example;

public class Employee {

    private String name;
    private String employeeId;
    private Rating rating;

    Employee(String name, String employeeId, Rating rating){
        this.name = name;
        this.employeeId = employeeId;
        this.rating = rating;
    }

    public void provideRating(int value, String provider){
        this.rating.provideRating(value, provider);
    }
}
