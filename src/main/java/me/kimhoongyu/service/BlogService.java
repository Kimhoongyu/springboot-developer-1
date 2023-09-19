package me.kimhoongyu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.kimhoongyu.domain.Article;
import me.kimhoongyu.dto.AddArticleRequest;
import me.kimhoongyu.dto.UpdateArticleRequest;
import me.kimhoongyu.repository.BlogRepository;

@RequiredArgsConstructor
@Service
public class BlogService {

	private final BlogRepository blogRepository;
	
	public Article save(AddArticleRequest request) {
		return blogRepository.save(request.toEntity());
	}
	
	public List<Article> findAll(){
		return blogRepository.findAll();
	}
	
	public Article findById(long id) {
		return blogRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("not found: " + id));
	}
	
	public void delete(long id) {
		blogRepository.deleteById(id);
	}
	
	@Transactional // 트랙잭션 메서드
	public Article update(long id, UpdateArticleRequest request) {
		Article article = blogRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("not found: " + id));
		
		article.update(request.getTitle(), request.getContent());
		
		return article;
	}
}
