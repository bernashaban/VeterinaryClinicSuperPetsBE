package com.example.veterinaryclinicsuperpets.dto.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {
  private Long id;
  private String title;
  private String description;
}
