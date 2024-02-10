package org.example;

public class Rating {
    int value;
    String provided_by;

    Rating(int value, String provider){
        this.value = value;
        this.provided_by = provider;
    }
    public void provideRating(int value, String provider){
        this.value = value;
        this.provided_by = provider;
    }
}
