// File: com.example.news.service.NewsService.java
package com.example.news.service;

import com.example.news.dto.NewsApiResponse;
import com.example.news.model.News;
import com.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void loadNewsFromApi() {
        String url = "https://newsapi.org/v2/everything?q=tesla&from=2025-03-22&sortBy=publishedAt&apiKey=900d2f2ecf7c46bea603ee34bdefc093";

        NewsApiResponse response = restTemplate.getForObject(url, NewsApiResponse.class);

        if (response != null && response.getArticles() != null) {
            for (NewsApiResponse.Article article : response.getArticles()) {
                News news = new News();
                news.setTitle(article.getTitle());
                news.setContent(article.getContent());
                newsRepository.save(news);
            }
        }
    }
}
