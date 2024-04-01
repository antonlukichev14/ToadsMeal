package com.example.toadsmeal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Parser {
    private String Title;
    private List<String> ingredients;
    private List<String> preparationSteps;
    private List<String> imageUrls;

    public Parser() {
        ingredients = new ArrayList<>();
        preparationSteps = new ArrayList<>();
        imageUrls = new ArrayList<>();
    }

    public void ParsingWeb(String url, String outPut){
        try{
            Document document = Jsoup.connect(url).get();

            Elements imgTitleElements = document.select("img.emotion-gxbcya");
            for (Element imgElement : imgTitleElements) {
                String imageUrl = imgElement.attr("src");
                imageUrls.add(imageUrl);
            }

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

            Elements imgElements = document.select("img.emotion-ducv57");
            for (Element imgElement : imgElements) {
                String imageUrl = imgElement.attr("src");
                imageUrls.add(imageUrl);
            }
            // Скачивание и сохранение изображения шагов приготовления
            downloadImages(imageUrls,outPut,preparationSteps, Title);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void downloadImages(List<String> imageUrls, String outputFolder, List<String> preparationSteps, String Title) {
        for (int i = 0; i < imageUrls.size(); i++) {
            String imageUrl = imageUrls.get(i);
            try {
                String fileName;
                String title = Title.replace(" ", "-");
                URL url = new URL(imageUrl);

                if(imageUrls.size() > preparationSteps.size())
                {
                    if (i == 0){
                        fileName = "image" + "Title" + "_" + title+imageUrl.substring(imageUrl.lastIndexOf("."));
                    }
                    else {
                        fileName = "image" + (i-1) + "_" + title+imageUrl.substring(imageUrl.lastIndexOf("."));
                    }
                }
                else{
                    fileName = "image" + i + "_" + title+imageUrl.substring(imageUrl.lastIndexOf("."));
                }

                try (InputStream in = url.openStream()) {

                    Path outputPath = Path.of(outputFolder, fileName);
                    Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        String outPut = "/images/";
        String url = "https://eda.ru/recepty/vypechka-deserty/brauni-brownie-20955";
        Parser _parser = new Parser();
        _parser.ParsingWeb(url, outPut);

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
