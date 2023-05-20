package com.nbsaas.life.talk.data.entity;


import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "talk_category")
public class TalkCategory extends CatalogEntity {


	private String path;

	private String icon;


	@ManyToOne(fetch = FetchType.LAZY)
	private TalkCategory parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<TalkCategory> children;


}
