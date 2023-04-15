package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.article.ArticleRequest;
import com.example.veterinaryclinicsuperpets.dto.article.ArticleResponse;
import com.example.veterinaryclinicsuperpets.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
  private final ArticleService articleService;

  @GetMapping("/{id}")
  public ArticleResponse getArticle(@PathVariable Long id) {
    return articleService.getById(id);
  }

  @GetMapping()
  public List<ArticleResponse> getAllArticles() {
    return articleService.getAll();
  }

  @DeleteMapping("/{id}")
  public ArticleResponse deleteArticle(@PathVariable Long id) {
    return articleService.delete(id);
  }

  @PostMapping()
  public Long postArticle(@RequestBody ArticleRequest request) {
    return articleService.create(request);
  }

  @PutMapping(value = "/{id}")
  public ArticleResponse updateArticle(@RequestBody ArticleRequest request, @PathVariable Long id) {
    return articleService.update(request, id);
  }
}
