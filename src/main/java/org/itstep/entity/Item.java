package org.itstep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "article", nullable = false)
	private String article;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "init_price")
	private Integer initPrice;

	public Item() {
	}
}
