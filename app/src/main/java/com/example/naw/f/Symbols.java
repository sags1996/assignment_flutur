package com.example.naw.f;

public enum Symbols {
    GALLILEO(100, "@drawable/galileo"),
    EINSTIEN(80, "@drawable/e"),
    CHARLES(75, "@drawable/c"),
    ISAAC(60, "@drawable/isaac"),
    DAWN(50, "@drawable/images"),
    MARIA(40, "@drawable/maria"),
    RITA(30, "@drawable/rita"),
    TELSA(20, "@drawable/tesla"),
    TULIP(10, "@drawable/tulip"),
    BANJAMIN(5, "@drawable/benj"),
    WRONG(1,"@drawable/thumb");


    public String imageName;
    public int value;

    Symbols(int value, String imageName){
        this.imageName = imageName;
        this.value = value;
    }

    public String getImageName() {
        return imageName;
    }

    public int getValue() {
        return value;
    }

}
