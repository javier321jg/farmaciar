/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Producto;
import com.example.plan.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javier_gr
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
private ProductoRepository productoRepository; 
    @Override
    public Producto create(Producto presentacion) {
        return productoRepository.save(presentacion);
    }

    @Override
    public Producto update(Producto presentacion) {
        return productoRepository.save(presentacion);
    }

    @Override
    public void delete(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto read(int id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public List<Producto> readAll() {
        return productoRepository.findAll();
    }
    
}
