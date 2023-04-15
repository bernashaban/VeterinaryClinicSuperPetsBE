package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.article.ArticleRequest;
import com.example.veterinaryclinicsuperpets.dto.article.ArticleResponse;
import com.example.veterinaryclinicsuperpets.entity.Article;
import com.example.veterinaryclinicsuperpets.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleMapperImpl implements ArticleMapper {
  @Override
  public ArticleResponse entityToResponse(Article entity) {
    ArticleResponse articleResponse = new ArticleResponse();
    articleResponse.setId(entity.getId());
    articleResponse.setDescription(entity.getDescription());
    articleResponse.setAdditionDate(entity.getAdditionDate());
    articleResponse.setTitle(entity.getTitle());
    articleResponse.setPhotoUrl(entity.getPhotoUrl());
    return articleResponse;
  }

  @Override
  public Article requestToEntity(ArticleRequest entityRequest) {
    Article article = new Article();
    article.setAdditionDate(LocalDateTime.now());
    article.setDescription(entityRequest.getDescription());
    article.setPhotoUrl(entityRequest.getPhotoUrl());
    article.setTitle(entityRequest.getTitle());
    return article;
  }

  @Override
  public List<ArticleResponse> listOfEntitiesToListOfResponses(List<Article> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
