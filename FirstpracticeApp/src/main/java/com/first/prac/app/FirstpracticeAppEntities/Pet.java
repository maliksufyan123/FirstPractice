package com.first.prac.app.FirstpracticeAppEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "Dog")
	private String Dog;

	@Column(name = "Cat")
	private String Cat;

	@Column(name = "Bird")
	private String Bird;

	public String getDog() {
		return Dog;

	
	}
	public Pet() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCat() {
		return Cat;
	}
	public void setCat(String cat) {
		Cat = cat;
	}
	public String getBird() {
		return Bird;
	}
	public void setBird(String bird) {
		Bird = bird;
	}
	public void setDog(String dog) {
		Dog = dog;
	}
	
	

}
