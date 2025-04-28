// File path: com/example/news/repository/NewsRepository.java
package com.example.news.repository;

import com.example.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByCategory(String category);
}
