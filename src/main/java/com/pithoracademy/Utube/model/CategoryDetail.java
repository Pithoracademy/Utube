package com.pithoracademy.Utube.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_detail")
public class CategoryDetail implements Serializable{

	/**
	 * @author Pithoracademy
	 */
	private static final long serialVersionUID = -8825773717267761280L;

	@Id
	@GeneratedValue
	@Column(name = "pk_catId")
	private Integer id;
	
	@Column(name = "cat_name")
	private String name;
	
	@Column(name = "cat_status")
	private Boolean active;
	
	@Column(name = "cat_desc")
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
