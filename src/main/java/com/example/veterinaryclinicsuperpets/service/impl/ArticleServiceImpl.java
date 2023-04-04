package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.article.ArticleRequest;
import com.example.veterinaryclinicsuperpets.dto.article.ArticleResponse;
import com.example.veterinaryclinicsuperpets.entity.Article;
import com.example.veterinaryclinicsuperpets.mapper.ArticleMapper;
import com.example.veterinaryclinicsuperpets.repository.ArticleRepository;
import com.example.veterinaryclinicsuperpets.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
  private final ArticleRepository articleRepository;
  private final ArticleMapper articleMapper;

  @Override
  public ArticleResponse getById(Long id) {
    Article article = articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return articleMapper.entityToResponse(article);
  }

  @Override
  public Long create(ArticleRequest request) {
    Article article = articleMapper.requestToEntity(request);
    return articleRepository.save(article).getId();
  }

  @Override
  public ArticleResponse delete(Long id) {
    Article article = articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    articleRepository.delete(article);
    return articleMapper.entityToResponse(article);
  }

  @Override
  public ArticleResponse update(ArticleRequest request, Long id) {
    Article article = articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!request.getDescription().equals(article.getDescription())) {
      article.setDescription(request.getDescription());
    }
    if (request.getTitle().equals(article.getTitle())) {
      article.setTitle(request.getTitle());
    }
    if (!request.getPhotoUrl().equals(article.getPhotoUrl())) {
      article.setPhotoUrl(request.getPhotoUrl());
    }
    return articleMapper.entityToResponse(article);
  }

  @Override
  public List<ArticleResponse> getAll() {
    List<Article> articles = (List<Article>) articleRepository.findAll();
    return articleMapper.listOfEntitiesToListOfResponses(articles);
  }
}
