package com.formation.blog.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.blog.model.Tag;
import com.formation.blog.repository.springdatajpa.SpringDataTagRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class TagService {

	private SpringDataTagRepository springDataTagRepository;
	
	@PersistenceContext
	EntityManager entityManager;

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
		return springDataTagRepository.findTagsById(articleId);
	}

//	@Transactional
//	public void addTagsToArticle(int articleId, Collection<Tag> tags) {
//		int tagId = 0;
//		for (Tag tag : tags) {
//			tagId = springDataTagRepository.findIdByName(tag.getName());
//			springDataTagRepository.addTagsToArticle(articleId, tagId);
//		}
//	}

//	@Transactional
//	public void addTagsToArticle(int articleId, Tag tag) {
//		int tagId = springDataTagRepository.findIdByName(tag.getName());
//		springDataTagRepository.addTagsToArticle(articleId, tagId);
//	}

	@Transactional
	public void addTagsToArticle(int articleId, Collection<Tag> tags) {
		String sqlRequest = "INSERT INTO HAVE_TAG (articleid, tagid) VALUES";
		int tagId = -1;
		
		for (Tag tag : tags) {
			
			if (tagId != -1) {
				tagId = springDataTagRepository.findIdByName(tag.getName());
				sqlRequest += ", (" + articleId + "," + tagId + ")";
			}
			else {
				tagId = springDataTagRepository.findIdByName(tag.getName());
				sqlRequest += "(" + articleId + "," + tagId + ")";
			}
		}

		entityManager.createNativeQuery(sqlRequest).executeUpdate();
	}

}
