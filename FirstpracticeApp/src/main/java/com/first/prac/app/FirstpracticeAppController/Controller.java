package com.first.prac.app.FirstpracticeAppController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.prac.app.FirstpracticeAppEntities.Pet;
import com.first.prac.app.FirstpracticeAppRepository.PetRepository;

@RestController
@RequestMapping("/api")

public class Controller {

	@Autowired
	private PetRepository petReposiotry;

	@GetMapping("/pet")
	public List<Pet> findAll() {
		return petReposiotry.findAll();

	}

	@GetMapping("/pet/{id}")
	public Pet findByid(@PathVariable int id) {
		Optional<Pet> optPet = petReposiotry.findById(id);
		if (!optPet.isPresent()) {
			throw new RuntimeException("Couldn't find user id: " + id);

		} else {
			return optPet.get();
		}

	}

	@PostMapping("/pet")
	public void addPet(@RequestBody Pet thePet) {
		petReposiotry.save(thePet);
		System.out.println("user added");
	}

	@PutMapping("/pet/{id}")
	public ResponseEntity<Object> updatePet(@PathVariable int id, @RequestBody Pet thePet) {
		Optional<Pet> optPet = petReposiotry.findById(id);
		if (!optPet.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			petReposiotry.save(thePet);
			return ResponseEntity.noContent().build();

		}

	}

	@DeleteMapping("/pet/{id}")
	public void deleteUser(@PathVariable int id) {
		Optional<Pet> optPet = petReposiotry.findById(id);
		if (!optPet.isPresent()) {
			throw new RuntimeException("User with the id: " + id + " not found to delete");
		} else {
			petReposiotry.deleteById(id);
		}
	}

}
