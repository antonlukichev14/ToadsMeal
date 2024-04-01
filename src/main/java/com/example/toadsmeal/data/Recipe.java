package com.example.toadsmeal.data;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Recipe {
    public String name; //Название блюда
    public  String description; //Описание блюда
    public String category; //Категория
    public Image image; //Изображение блюда
    private int difficulty; //Сложность
    private int portions; //Кол-во порций
    public int cookingTimeMinutes; //Время приготовления (в минутах)
    public final List<Ingridient> ingredients = new ArrayList<Ingridient>(); //Список ингридиентов
    public final List<Step> steps = new ArrayList<>(); //Шаги приготовления
    public boolean favorite; //Избранный

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int value) {
        int min = 1;
        int max = 5;
        this.difficulty = Math.max(min, Math.min(max, value));
    }

    public Nutrients getNutrients() {
        //Реализовать подсчёт Nutrients
        return null;
    }
}
