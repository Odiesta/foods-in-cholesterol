package com.odiestas;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Foods {

    private SimpleStringProperty name;
    private SimpleIntegerProperty cholesterol;

    public Foods(String name, Integer cholesterol) {
        this.name = new SimpleStringProperty(name);
        this.cholesterol = new SimpleIntegerProperty(cholesterol);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getCholesterol() {
        return cholesterol.get();
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol.set(cholesterol);
    }
}
