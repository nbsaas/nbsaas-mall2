package com.quhaodian.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 数据字典
 * @author 年高
 *
 */
@Entity
@Table(name="dictionary_info")
public class Dictionary {

	
	/**
	 * 数据字典id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	/**
	 * 数据字典值
	 */
	@Column(name="value_info")
	private String value;

	/**
	 * 数据字典键
	 */
	@Column(name="name_info")
	private String name;

	/**
	 * 数据字分类
	 */
	@Column(name="type_info")
	private String type;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
