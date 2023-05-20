package com.nbsaas.life.talk.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.life.user.data.entity.UserInfo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "talk")
public class Talk extends AbstractEntity {

	@Column(length=6000)
	private String message;
	
	@Column(length=6000)
	private String lastMessage;
	

	@Column(length=100)
	private String topic;
	
	

	private Integer subscribe=0;


	private Integer replies=0;


	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo user;

	
	@ManyToOne
	private TalkCategoryArea area;


}
