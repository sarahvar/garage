// Définition du package dans lequel se trouve la classe Car
package io.spring.garageApp.model;

// Définition de la classe Car
public class Car {
    
    // Définition d'un enum pour représenter les couleurs de la voiture
    public enum Color {
        RED, BLUE, BROWN, YELLOW
    }

    // Définition des attributs de la classe Car
    private String model; // Modèle de la voiture
    private String brand; // Marque de la voiture
    private int year; // Année de fabrication de la voiture
    private Color color; // Couleur de la voiture

    // Constructeur de la classe Car
    public Car(String model, String brand, int year, Color color) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.color = color;
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
