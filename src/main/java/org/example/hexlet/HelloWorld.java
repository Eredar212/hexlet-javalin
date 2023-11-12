package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");
            ctx.result(String.format("Hello, %s!", name == null ? "World" : name));
        });
        app.get("/users/{id}/post/{postId}", ctx -> {
            ctx.result(String.format("User Id: %s\nPost Id: %s", ctx.pathParam("id"), ctx.pathParam("postId")));
        });
        app.start(7070); // Стартуем веб-сервер
    }
}