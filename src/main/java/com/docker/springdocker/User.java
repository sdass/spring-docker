package com.docker.springdocker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usr")
@Getter @Setter
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	  private Integer id;

	  private String name;

	  private String address;


}
