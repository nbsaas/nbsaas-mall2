package com.nbsaas.life.talk.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.area.data.entity.Area;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "talk_category_area")
public class TalkCategoryArea extends AbstractEntity {


	@ManyToOne
	private Area area;

	@ManyToOne(fetch = FetchType.LAZY)
	private TalkCategory talkCategory;


	private Integer size;

}
