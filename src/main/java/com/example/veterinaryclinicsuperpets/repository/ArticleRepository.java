package com.example.veterinaryclinicsuperpets.repository;

import com.example.veterinaryclinicsuperpets.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
