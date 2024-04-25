package com.example.garageApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
// ajout de la classe Car qui permet de creer une nouvelle entite dans la base de donnees

public class Car {


    enum Color {
        rouge,
        bleu,
        vert,
        jaune,
        noire,
        blanc,
        orange,
        violet,
        marron,
        gris,
        argent
    }

    @Id
    // ajout de l attribut id qui permet de creer une nouvelle entite dans la base de donnees
    private long id;
    private String model;
    private String brand;
    @Column(name = "released_year")
    private int year;
    private Color color;

    // ajout d un constructeur vide qui permet la creation d une nouvelle voiture
    // et ajout de la fonction SUPER dans le contructeur classique ci dessous
    //
    public Car() {
    }
    public Car(long id, String model, String brand, int year, String color) {
        super(); // pour aider le constructeur vide a creer une nouvealle voiture

        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.color = Color.valueOf(color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
