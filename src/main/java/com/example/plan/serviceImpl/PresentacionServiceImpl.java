/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Presentacion;
import com.example.plan.repository.PresentacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javier_gr
 */
@Service
public class PresentacionServiceImpl implements PresentacionService{
    @Autowired
private PresentacionRepository presentacionRepository;
    @Override
    public Presentacion create(Presentacion presentacion) {
        return presentacionRepository.save(presentacion);
    }

    @Override
    public Presentacion update(Presentacion presentacion) {
        return presentacionRepository.save(presentacion);
    }

    @Override
    public void delete(int id) {
        presentacionRepository.deleteById(id);
    }

    @Override
    public Presentacion read(int id) {
        return presentacionRepository.findById(id).get();
    }

    @Override
    public List<Presentacion> readAll() {
        return presentacionRepository.findAll();
    }
    
}
