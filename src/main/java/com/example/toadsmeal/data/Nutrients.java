package com.example.toadsmeal.data;

public class Nutrients {
    private static final int PROTEIN_CALORIES_PER_GRAM = 4;
    private static final int FAT_CALORIES_PER_GRAM = 9;
    private static final int CARB_CALORIES_PER_GRAM = 4;

    public float proteinGrams; //Количество белка на 100 грамм продукта
    public float fatGrams; //Количество жиров на 100 грамм продукта
    public float carbGrams; //Количество углеводов на 100 грамм продукта

    public Nutrients(){

    }

    public Nutrients(int _proteinGrams, int _fatGrams, int _carbGrams){
        proteinGrams = _proteinGrams;
        fatGrams = _fatGrams;
        carbGrams = _carbGrams;
    }

    public int calories()
    {
        float sum = PROTEIN_CALORIES_PER_GRAM * proteinGrams + FAT_CALORIES_PER_GRAM * fatGrams + CARB_CALORIES_PER_GRAM * carbGrams;
        return (int)Math.ceil(sum);
    }

    public int caloriesPerGram()
    {
        float sum = proteinGrams + fatGrams + carbGrams;
        return (int)Math.ceil(calories() / sum);
    }
}
