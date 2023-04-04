package com.example.veterinaryclinicsuperpets.dto.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {
  private Long id;
  private String title;
  private String description;
  private String photoUrl;
  private LocalDateTime additionDate;
}
