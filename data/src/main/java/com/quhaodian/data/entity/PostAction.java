package com.quhaodian.data.entity;

import com.quhaodian.user.data.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "postaction")
public class PostAction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	@ManyToOne
	@JoinColumn(name="userid",unique = true)
	private UserInfo user;
}
