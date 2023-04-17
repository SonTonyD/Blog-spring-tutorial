package com.formation.blog.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
	
	@Column(name = "author")
	private String author;

	@Column(name = "content")
	private String content;
	
	@Column(name = "article_id")
	private int articleId;

	@Override
	public int hashCode() {
		return Objects.hash(articleId, author, content, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return articleId == other.articleId && Objects.equals(author, other.author)
				&& Objects.equals(content, other.content) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", author=" + author + ", content=" + content + ", article_id=" + articleId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

}
