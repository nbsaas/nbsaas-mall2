package com.openyelp.data.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "content")
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	private String title;

	@OneToOne
	@JoinColumn(name = "content_count_id")
	private ContentCount contentCount;

	@JoinTable(name = "content_tags")
	@ManyToMany()
	private Set<ContentTag> tags;

	public Set<ContentTag> getTags() {
		return tags;
	}

	public void addTag(String tag) {
		if (tags == null) {
			tags = new HashSet<ContentTag>();
		}
		ContentTag tagtemp=new ContentTag();
		tagtemp.setName(tag);
		tags.add(tagtemp);
	}

	public void setTags(Set<ContentTag> tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ContentCount getContentCount() {
		return contentCount;
	}

	public void setContentCount(ContentCount contentCount) {
		this.contentCount = contentCount;
	}

}
