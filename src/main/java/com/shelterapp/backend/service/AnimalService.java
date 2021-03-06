package com.shelterapp.backend.service;

import com.shelterapp.backend.entity.Animal;
import com.shelterapp.backend.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AnimalService {

    //JSON packet key string must match exactly with column name, case and syntax
    //if not posting booleans, GET request to see the formatting of the column names
    //copy and paste from the ResponseBody, the exact column name

    @Autowired
    private AnimalRepository animalRepository;

    public Animal getAnimal(UUID id) {
        return animalRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void save(Animal animal) {
        animalRepository.save(animal);
    }

    public ResponseEntity<List<Animal>> findAll() {
        List<Animal> animalList = animalRepository.findAll();
        if (animalList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animalList);
    }

    public ResponseEntity<List<Animal>> findBySpecies(String species) {
        List<Animal> animalList = animalRepository.findBySpecies(species);
        if (animalList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animalList);
    }
}
