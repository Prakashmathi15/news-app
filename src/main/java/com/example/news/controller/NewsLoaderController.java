package com.example.news.controller;

import com.example.news.model.News;
import com.example.news.service.NewsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsLoaderController {

    @Autowired
    private NewsApiService newsApiService;

    @GetMapping("/")
    public String loadNewsFromApi(Model model) {
        // Fetch and store news
        String result = newsApiService.fetchAndStoreNews().toString();
        System.out.println(result);

        // Fetch all stored news from the database
        model.addAttribute("articles", newsApiService.getAllNews());

        // Return the Thymeleaf view name
        return "news";
    }
}
