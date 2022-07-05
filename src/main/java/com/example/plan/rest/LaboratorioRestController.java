/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.rest;


import com.example.plan.entity.Laboratorio;

import com.example.plan.serviceImpl.LaboratorioService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/laboratorio")
public class LaboratorioRestController {

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping("/all")
    public List<Laboratorio> getPosts() {
        return laboratorioService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> getPost(@PathVariable int id) {
        Laboratorio laboratorio = laboratorioService.read(id);
        return ResponseEntity.ok(laboratorio);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        laboratorioService.delete(id);
    }
    @PostMapping("/add")
    public Laboratorio addPost(@RequestBody Laboratorio laboratorio, @RequestParam("foto") MultipartFile imagen) {  
        return laboratorioService.create(laboratorio);
    }
    @PutMapping("/edit")
    public Laboratorio editPost(@RequestBody Laboratorio laboratorio) {  
        //Autor aut = new Autor(autor.getId(),autor.getNombres(),autor.getApellidos(), autor.getEstado());        
        return laboratorioService.update(laboratorio);
    }
}

