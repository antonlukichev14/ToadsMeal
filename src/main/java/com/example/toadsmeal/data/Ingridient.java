package com.example.toadsmeal.data;

public class Ingridient
{
    public String name;
    public int grams;
    public Nutrients nutrients;

    public int calories()
    {
        return nutrients.caloriesPerGram() * grams;
    }
}