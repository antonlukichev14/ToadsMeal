package com.example.toadsmeal.data;

public class Ingridient
{
    private String name;
    private int grams;
    private Nutrients nutrients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public int calories()
    {
        return nutrients.caloriesPerGram() * grams;
    }
}