package com.example.toadsmeal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:recipes.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // Создание таблицы Recipes
            String createRecipesTable = "CREATE TABLE IF NOT EXISTS Recipes (" +
                    "recipe_id INTEGER PRIMARY KEY," +
                    "title TEXT," +
                    "description TEXT," +
                    "categories TEXT," +
                    "img_link TEXT," +
                    "difficulty INTEGER," +
                    "servings INTEGER" +
                    "prep_time INTEGER," +
                    "cook_time INTEGER," +
                    "favourite BOOL" +
                    ")";
            stmt.execute(createRecipesTable);

            // Создание таблицы Ingredients
            String createIngredientsTable = "CREATE TABLE IF NOT EXISTS Ingredients (" +
                    "ingredient_id INTEGER PRIMARY KEY," +
                    "name TEXT," +
                    "protein FLOAT," +
                    "fat FLOAT," +
                    "carbon FLOAT" +
                    ")";
            stmt.execute(createIngredientsTable);

            // Создание таблицы Recipe_Ingredients
            String createRecipeIngredientsTable = "CREATE TABLE IF NOT EXISTS Recipe_Ingredients (" +
                    "recipe_id INTEGER," +
                    "ingredient_id INTEGER," +
                    "quantity REAL," +
                    "unit TEXT," +
                    "PRIMARY KEY (recipe_id, ingredient_id)," +
                    "FOREIGN KEY (recipe_id) REFERENCES Recipes(recipe_id)," +
                    "FOREIGN KEY (ingredient_id) REFERENCES Ingredients(ingredient_id)" +
                    ")";
            stmt.execute(createRecipeIngredientsTable);

            System.out.println("Таблицы созданы успешно");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблиц: " + e.getMessage());
        }
    }
}
