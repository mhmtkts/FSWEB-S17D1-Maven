package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String projectDeveloperFullname;


    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping
    public void save(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal save(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, animal);
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal save(@PathVariable int id){
        return animals.remove(id);
    }


}

