package com.example.toadsmeal.data;

public class Ingridient
{
    public Product product;
    public int grams;

    public int calories()
    {
        return product.nutrients.caloriesPerGram() * grams;
    }

    public float getProteinGrams() {return (product.nutrients.proteinGrams / 100) * grams;}
    public float getFatGrams() {return (product.nutrients.fatGrams / 100) * grams;}
    public float getCarbGrams() {return (product.nutrients.carbGrams / 100) * grams;}
}