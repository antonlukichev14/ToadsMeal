package com.example.toadsmeal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String Title;
    private List<String> ingredients;
    private List<String> preparationSteps;

    public Parser() {
        ingredients = new ArrayList<>();
        preparationSteps = new ArrayList<>();
    }

    public void ParsingWeb(String url){
        try{
            Document document = Jsoup.connect(url).get();

            Element titleElement = document.select("h1.emotion-gl52ge").get(0);
            String title = (titleElement != null) ? titleElement.text() : "Название не найдено";
            Title = title;

            Elements ingredientElements = document.select("div.emotion-1oyy8lz");
            for (Element ingredientElement : ingredientElements) {
                ingredients.add(ingredientElement.text());
            }

            Elements preparationStepElements = document.select("span.emotion-wdt5in");
            for (Element preparationStepElement : preparationStepElements) {
                preparationSteps.add(preparationStepElement.text());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return Title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getPreparationSteps() {
        return preparationSteps;
    }



    //Для тестов
    public static void main(String[] args) {
        String url = "https://eda.ru/recepty/vypechka-deserty/brauni-brownie-20955";
        Parser _parser = new Parser();
        _parser.ParsingWeb(url);

        String title = _parser.getTitle();
        List<String> ingredients = _parser.getIngredients();
        List<String> preparationSteps = _parser.getPreparationSteps();

        if (title != null) {
            System.out.println("Название блюда: " + title);
        } else {
            System.out.println("Название блюда не найдено");
        }

        if (ingredients != null) {
            System.out.println("Ингредиенты:");
            int a = 1;
            for (String ingredient : ingredients) {
                System.out.println(a + ". " + ingredient);
                a++;
            }
        } else {
            System.out.println("Ингредиенты не найдены");
        }

        if (preparationSteps != null) {
            System.out.println("Шаги приготовления:");
            int a = 1;
            for (String step : preparationSteps) {
                System.out.println(a + ". " + step);
                a++;
            }
        } else {
            System.out.println("Шаги приготовления не найдены");
        }
    }
}
