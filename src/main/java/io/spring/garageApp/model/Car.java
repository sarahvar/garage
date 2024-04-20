// Définition du package dans lequel se trouve la classe Car
package io.spring.garageApp.model;

import javax.persistence.*;


@Entity
// Définition de la classe Car
public class Car {
    
    // Définition d'un enum pour représenter les couleurs de la voiture
    public enum Color {
        RED, BLUE, BROWN, YELLOW
    }

    // Définition des attributs de la classe Car
    @Id
    private long id;
    private String model; // Modèle de la voiture
    private String brand; // Marque de la voiture
    private int year; // Année de fabrication de la voiture
    private Color color; // Couleur de la voiture

    public Car() {}

    // Constructeur de la classe Car
    public Car(long id, String model, String brand, int year, Color color) {
        super();
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    // Méthode getter pour sélectionner l'identifiant de la voiture
    public long getId() {
        return id;
    }

    // Méthode setter pour définir l'identifiant de la voiture
    public void setId(long id) {
        this.id = id;
    }

    // Méthode getter pour récupérer le modèle de la voiture
    public String getModel() {
        return model;
    }

    // Méthode setter pour définir le modèle de la voiture
    public void setModel(String model) {
        this.model = model;
    }

    // Méthode getter pour récupérer la marque de la voiture
    public String getBrand() {
        return brand;
    }

    // Méthode setter pour définir la marque de la voiture
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Méthode getter pour récupérer l'année de fabrication de la voiture
    public int getYear() {
        return year;
    }

    // Méthode setter pour définir l'année de fabrication de la voiture
    public void setYear(int year) {
        this.year = year;
    }

    // Méthode getter pour récupérer la couleur de la voiture
    public Color getColor() {
        return color;
    }

    // Méthode setter pour définir la couleur de la voiture
    public void setColor(Color color) {
        this.color = color;
    }
}
