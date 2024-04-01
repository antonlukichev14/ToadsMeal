package com.example.toadsmeal.data;

public class Nutrients {
    private static final int PROTEIN_CALORIES_PER_GRAM = 4;
    private static final int FAT_CALORIES_PER_GRAM = 9;
    private static final int CARB_CALORIES_PER_GRAM = 4;

    public int proteinGrams;
    public int fatGrams;
    public int carbGrams;

    public int calories()
    {
        int sum =
                PROTEIN_CALORIES_PER_GRAM * proteinGrams + FAT_CALORIES_PER_GRAM * fatGrams + CARB_CALORIES_PER_GRAM * carbGrams;
        return sum;
    }

    public int caloriesPerGram()
    {
        int sum = proteinGrams + fatGrams + carbGrams;
        return calories() / sum;
    }
}
