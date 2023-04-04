package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.article.ArticleRequest;
import com.example.veterinaryclinicsuperpets.dto.article.ArticleResponse;

import java.util.List;

public interface ArticleService {
  ArticleResponse getById(Long id);

  Long create(ArticleRequest request);

  ArticleResponse delete(Long id);

  ArticleResponse update(ArticleRequest request, Long id);

  List<ArticleResponse> getAll();
}
