package com.example.toadsmeal.data;

public class Nutrients {
    private static final int PROTEIN_CALORIES_PER_GRAM = 4;
    private static final int FAT_CALORIES_PER_GRAM = 9;
    private static final int CARB_CALORIES_PER_GRAM = 4;

    private int proteinGrams;
    private int fatGrams;
    private int carbGrams;

    public int getProteinGrams() {
        return proteinGrams;
    }

    public void setProteinGrams(int proteinGrams) {
        this.proteinGrams = proteinGrams;
    }

    public int getFatGrams() {
        return fatGrams;
    }

    public void setFatGrams(int fatGrams) {
        this.fatGrams = fatGrams;
    }

    public int getCarbGrams() {
        return carbGrams;
    }

    public void setCarbGrams(int carbGrams) {
        this.carbGrams = carbGrams;
    }

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
