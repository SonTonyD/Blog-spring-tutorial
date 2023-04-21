package com.formation.blog.repository.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.blog.model.Tag;

public interface SpringDataTagRepository extends JpaRepository<Tag, Integer> {

}
