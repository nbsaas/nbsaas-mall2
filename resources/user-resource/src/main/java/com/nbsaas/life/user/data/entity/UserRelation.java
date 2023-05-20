package com.nbsaas.life.user.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "user_relation")
public class UserRelation extends AbstractEntity {


	
	
	@ManyToOne
	private UserInfo user;
	
	
	@ManyToOne
	private UserInfo friend;
	
	private Integer state;
	
	@Column(length=500)
	private String message;
	


}
