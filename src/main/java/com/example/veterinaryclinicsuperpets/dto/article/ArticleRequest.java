package com.example.veterinaryclinicsuperpets.dto.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {
  // no id
  private String title;
  private String description;
  private String photoUrl;
  // not necessary in body, will take the date and time from system
  // private LocalDateTime additionDate;
}
