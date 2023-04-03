package com.example.veterinaryclinicsuperpets.mapper;

import com.example.veterinaryclinicsuperpets.dto.article.ArticleRequest;
import com.example.veterinaryclinicsuperpets.dto.article.ArticleResponse;
import com.example.veterinaryclinicsuperpets.entity.Article;

import java.util.List;

public interface ArticleMapper {
  ArticleResponse entityToResponse(Article entity);

  Article requestToEntity(ArticleRequest entityRequest);

  List<ArticleResponse> listOfEntitiesToListOfResponses(List<Article> entities);
}
