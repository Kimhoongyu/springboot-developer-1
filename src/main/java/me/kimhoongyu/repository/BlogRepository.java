package me.kimhoongyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.kimhoongyu.domain.Article;

public interface BlogRepository  extends JpaRepository<Article, Long>{

}
