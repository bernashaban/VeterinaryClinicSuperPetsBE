package com.example.veterinaryclinicsuperpets.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.veterinaryclinicsuperpets.dto.article.ArticleRequest;
import com.example.veterinaryclinicsuperpets.dto.article.ArticleResponse;
import com.example.veterinaryclinicsuperpets.entity.Article;
import com.example.veterinaryclinicsuperpets.mapper.ArticleMapper;
import com.example.veterinaryclinicsuperpets.repository.ArticleRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ArticleServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ArticleServiceImplTest {
    @MockBean
    private ArticleMapper articleMapper;

    @MockBean
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    /**
     * Method under test: {@link ArticleServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        Article article = new Article();
        article.setDescription("The answer of a qusetion.");
        article.setId(123L);
        article.setTitle("Question");
        Optional<Article> ofResult = Optional.of(article);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        ArticleResponse articleResponse = new ArticleResponse();
        when(articleMapper.entityToResponse((Article) any())).thenReturn(articleResponse);
        assertSame(articleResponse, articleServiceImpl.getById(123L));
        verify(articleRepository).findById((Long) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#getById(Long)}
     */
    @Test
    void testGetById2() {
        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        when(articleMapper.entityToResponse((Article) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> articleServiceImpl.getById(123L));
        verify(articleRepository).findById((Long) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#getById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.example.veterinaryclinicsuperpets.service.impl.ArticleServiceImpl.getById(ArticleServiceImpl.java:22)
        //   In order to prevent getById(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(articleRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(articleMapper.entityToResponse((Article) any())).thenReturn(new ArticleResponse());
        articleServiceImpl.getById(123L);
    }

    /**
     * Method under test: {@link ArticleServiceImpl#create(ArticleRequest)}
     */
    @Test
    void testCreate() {
        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article);

        Article article1 = new Article();
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleMapper.requestToEntity((ArticleRequest) any())).thenReturn(article1);
        assertEquals(123L,
                articleServiceImpl.create(new ArticleRequest("Dr", "The characteristics of someone or something")).longValue());
        verify(articleRepository).save((Article) any());
        verify(articleMapper).requestToEntity((ArticleRequest) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#create(ArticleRequest)}
     */
    @Test
    void testCreate2() {
        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article);
        when(articleMapper.requestToEntity((ArticleRequest) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class,
                () -> articleServiceImpl.create(new ArticleRequest("Dr", "The characteristics of someone or something")));
        verify(articleMapper).requestToEntity((ArticleRequest) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);
        doNothing().when(articleRepository).delete((Article) any());
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        ArticleResponse articleResponse = new ArticleResponse();
        when(articleMapper.entityToResponse((Article) any())).thenReturn(articleResponse);
        assertSame(articleResponse, articleServiceImpl.delete(123L));
        verify(articleRepository).findById((Long) any());
        verify(articleRepository).delete((Article) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#delete(Long)}
     */
    @Test
    void testDelete2() {
        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);
        doNothing().when(articleRepository).delete((Article) any());
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        when(articleMapper.entityToResponse((Article) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> articleServiceImpl.delete(123L));
        verify(articleRepository).findById((Long) any());
        verify(articleRepository).delete((Article) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#delete(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.example.veterinaryclinicsuperpets.service.impl.ArticleServiceImpl.delete(ArticleServiceImpl.java:34)
        //   In order to prevent delete(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(articleRepository).delete((Article) any());
        when(articleRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(articleMapper.entityToResponse((Article) any())).thenReturn(new ArticleResponse());
        articleServiceImpl.delete(123L);
    }

    /**
     * Method under test: {@link ArticleServiceImpl#update(ArticleRequest, Long)}
     */
    @Test
    void testUpdate() {
        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);

        Article article1 = new Article();
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article1);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        ArticleResponse articleResponse = new ArticleResponse();
        when(articleMapper.entityToResponse((Article) any())).thenReturn(articleResponse);
        assertSame(articleResponse,
                articleServiceImpl.update(new ArticleRequest("Dr", "The characteristics of someone or something"), 123L));
        verify(articleRepository).save((Article) any());
        verify(articleRepository).findById((Long) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#update(ArticleRequest, Long)}
     */
    @Test
    void testUpdate2() {
        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);

        Article article1 = new Article();
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article1);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        when(articleMapper.entityToResponse((Article) any()))
                .thenThrow(new IllegalArgumentException("The characteristics of someone or something"));
        assertThrows(IllegalArgumentException.class,
                () -> articleServiceImpl.update(new ArticleRequest("Dr", "The characteristics of someone or something"), 123L));
        verify(articleRepository).save((Article) any());
        verify(articleRepository).findById((Long) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#update(ArticleRequest, Long)}
     */
    @Test
    void testUpdate3() {
        Article article = mock(Article.class);
        when(article.getDescription()).thenReturn("foo");
        when(article.getTitle()).thenReturn("Dr");
        doNothing().when(article).setDescription((String) any());
        doNothing().when(article).setId((Long) any());
        doNothing().when(article).setTitle((String) any());
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);

        Article article1 = new Article();
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article1);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        ArticleResponse articleResponse = new ArticleResponse();
        when(articleMapper.entityToResponse((Article) any())).thenReturn(articleResponse);
        assertSame(articleResponse,
                articleServiceImpl.update(new ArticleRequest("Dr", "The characteristics of someone or something"), 123L));
        verify(articleRepository).save((Article) any());
        verify(articleRepository).findById((Long) any());
        verify(article).getDescription();
        verify(article).getTitle();
        verify(article, atLeast(1)).setDescription((String) any());
        verify(article).setId((Long) any());
        verify(article).setTitle((String) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#update(ArticleRequest, Long)}
     */
    @Test
    void testUpdate4() {
        Article article = mock(Article.class);
        when(article.getDescription()).thenReturn("The characteristics of someone or something");
        when(article.getTitle()).thenReturn("foo");
        doNothing().when(article).setDescription((String) any());
        doNothing().when(article).setId((Long) any());
        doNothing().when(article).setTitle((String) any());
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);

        Article article1 = new Article();
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article1);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        ArticleResponse articleResponse = new ArticleResponse();
        when(articleMapper.entityToResponse((Article) any())).thenReturn(articleResponse);
        assertSame(articleResponse,
                articleServiceImpl.update(new ArticleRequest("Dr", "The characteristics of someone or something"), 123L));
        verify(articleRepository).save((Article) any());
        verify(articleRepository).findById((Long) any());
        verify(article).getDescription();
        verify(article).getTitle();
        verify(article).setDescription((String) any());
        verify(article).setId((Long) any());
        verify(article, atLeast(1)).setTitle((String) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#update(ArticleRequest, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.example.veterinaryclinicsuperpets.service.impl.ArticleServiceImpl.update(ArticleServiceImpl.java:41)
        //   In order to prevent update(ArticleRequest, Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(ArticleRequest, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Article article = new Article();
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article);
        when(articleRepository.findById((Long) any())).thenReturn(Optional.empty());
        Article article1 = mock(Article.class);
        when(article1.getDescription()).thenReturn("The characteristics of someone or something");
        when(article1.getTitle()).thenReturn("Dr");
        doNothing().when(article1).setDescription((String) any());
        doNothing().when(article1).setId((Long) any());
        doNothing().when(article1).setTitle((String) any());
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleMapper.entityToResponse((Article) any())).thenReturn(new ArticleResponse());
        articleServiceImpl.update(new ArticleRequest("Dr", "The characteristics of someone or something"), 123L);
    }

    /**
     * Method under test: {@link ArticleServiceImpl#update(ArticleRequest, Long)}
     */
    @Test
    void testUpdate6() {
        Article article = mock(Article.class);
        when(article.getDescription()).thenReturn("The characteristics of someone or something");
        when(article.getTitle()).thenReturn("Dr");
        doNothing().when(article).setDescription((String) any());
        doNothing().when(article).setId((Long) any());
        doNothing().when(article).setTitle((String) any());
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);

        Article article1 = new Article();
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article1);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        ArticleResponse articleResponse = new ArticleResponse();
        when(articleMapper.entityToResponse((Article) any())).thenReturn(articleResponse);
        assertSame(articleResponse, articleServiceImpl.update(new ArticleRequest(), 123L));
        verify(articleRepository).save((Article) any());
        verify(articleRepository).findById((Long) any());
        verify(article).setDescription((String) any());
        verify(article).setId((Long) any());
        verify(article).setTitle((String) any());
        verify(articleMapper).entityToResponse((Article) any());
    }

    /**
     * Method under test: {@link ArticleServiceImpl#update(ArticleRequest, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.veterinaryclinicsuperpets.dto.article.ArticleRequest.getDescription()" because "request" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.ArticleServiceImpl.update(ArticleServiceImpl.java:42)
        //   In order to prevent update(ArticleRequest, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(ArticleRequest, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Article article = mock(Article.class);
        when(article.getDescription()).thenReturn("The characteristics of someone or something");
        when(article.getTitle()).thenReturn("Dr");
        doNothing().when(article).setDescription((String) any());
        doNothing().when(article).setId((Long) any());
        doNothing().when(article).setTitle((String) any());
        article.setDescription("The characteristics of someone or something");
        article.setId(123L);
        article.setTitle("Dr");
        Optional<Article> ofResult = Optional.of(article);

        Article article1 = new Article();
        article1.setDescription("The characteristics of someone or something");
        article1.setId(123L);
        article1.setTitle("Dr");
        when(articleRepository.save((Article) any())).thenReturn(article1);
        when(articleRepository.findById((Long) any())).thenReturn(ofResult);
        when(articleMapper.entityToResponse((Article) any())).thenReturn(new ArticleResponse());
        articleServiceImpl.update(null, 123L);
    }

    /**
     * Method under test: {@link ArticleServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        when(articleRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> articleServiceImpl.getAll());
        verify(articleRepository).findAll();
    }
}

