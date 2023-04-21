package com.formation.blog.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Tag;
import com.formation.blog.repository.springdatajpa.SpringDataTagRepository;

@Service
public class TagService {
	
	private SpringDataTagRepository springDataTagRepository;

	@Autowired
	public TagService(SpringDataTagRepository springDataTagRepository) {
		this.springDataTagRepository = springDataTagRepository;
	}
	
	@Transactional
	public Collection<Tag> getTags() {
		return springDataTagRepository.findAll();
	}
	
	@Transactional
	public void createTag(Tag tag) {
		springDataTagRepository.save(tag);
	}
	
	@Transactional
	public Collection<Tag> getArticleTags(int articleId) {
		return springDataTagRepository.findTags(articleId);
	}

}
