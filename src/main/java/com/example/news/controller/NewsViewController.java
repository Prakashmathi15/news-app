package com.example.news.controller;

import com.example.news.model.News;
import com.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NewsViewController {

    @Autowired
    private NewsRepository newsRepository;

    // All News

    @GetMapping("/news/all")
    public String allNews(Model model) {
        List<News> all = newsRepository.findAll();
        model.addAttribute("newsList", all);
        model.addAttribute("activeTab", "all");
        return "news";
    }

    // National News
    @GetMapping("/news/national")
    public String nationalNews(Model model) {
        List<News> national = newsRepository.findByCategory("national");
        model.addAttribute("newsList", national);
        model.addAttribute("activeTab", "national");
        return "news";
    }

    // International News
    @GetMapping("/news/international")
    public String internationalNews(Model model) {
        List<News> international = newsRepository.findByCategory("international");
        model.addAttribute("newsList", international);
        model.addAttribute("activeTab", "international");
        return "news";
    }
}
