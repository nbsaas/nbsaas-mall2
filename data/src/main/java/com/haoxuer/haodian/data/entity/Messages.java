package com.haoxuer.haodian.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.haoxuer.discover.user.data.entity.UserInfo;
import org.hibernate.annotations.ColumnDefault;



/**
 * 消息
 * @author andrea
 *
 */
@Entity
@Table(name = "messages")
public class Messages implements Serializable ,Cloneable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;
	
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fromuserid")
	private UserInfo from;
	
	/**
	 * 已发是否显示
	 */
	@ColumnDefault("0")
	private Integer fromhide;
	
	
	/**
	 * 收件人是否显示
	 */
	@ColumnDefault("0")
	private Integer tohide=0;
	
	

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="touserid")
	private UserInfo to;

	private String title;

	private String contents;

	private Date addDate;

	/**
	 * 类型  1为接受 2为发送
	 */
	private Integer typeinfo;
	
	
	public Date getAddDate() {
		return addDate;
	}
	
	public String getContents() {
		return contents;
	}
	
	public UserInfo getFrom() {
		return from;
	}
	
	public Integer getFromhide() {
		return fromhide;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public UserInfo getTo() {
		return to;
	}

	public Integer getTohide() {
		return tohide;
	}

	public Integer getTypeinfo() {
		return typeinfo;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setFrom(UserInfo from) {
		this.from = from;
	}

	public void setFromhide(Integer fromhide) {
		this.fromhide = fromhide;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTo(UserInfo to) {
		this.to = to;
	}

	public void setTohide(Integer tohide) {
		this.tohide = tohide;
	}

	public void setTypeinfo(Integer typeinfo) {
		this.typeinfo = typeinfo;
	}
	
	
	
	
}
