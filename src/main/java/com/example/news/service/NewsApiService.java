package com.example.news.service;

import com.example.news.model.News;
import com.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NewsApiService {

    private static final String API_KEY = "900d2f2ecf7c46bea603ee34bdefc093";
    private static final String URL = "https://newsapi.org/v2/everything?q=tesla&from=2025-03-22&sortBy=publishedAt&apiKey=" + API_KEY;

    @Autowired
    private NewsRepository newsRepository;


    public List<News> getAllNews() {
        return newsRepository.findAll();  // This will fetch all news from the database
    }
    public List<News> fetchAndStoreNews() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(URL, Map.class);

        List<Map<String, Object>> articles = (List<Map<String, Object>>) response.get("articles");

        List<News> newsList = new ArrayList<>();
        for (Map<String, Object> article : articles) {
            News news = new News();
            news.setTitle((String) article.get("title"));
            news.setContent((String) article.get("description"));
            news.setAuthor((String) article.get("author"));
            news.setPublishedDate((String) article.get("publishedAt"));
            news.setCategory("Top News");

            newsList.add(newsRepository.save(news));
        }

        return newsList;
    }
}
