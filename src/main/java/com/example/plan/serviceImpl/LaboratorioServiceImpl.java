/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Laboratorio;
import com.example.plan.repository.LaboratorioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javier_gr
 */
@Service
public class LaboratorioServiceImpl implements LaboratorioService{
    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Override
    public Laboratorio create(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    public Laboratorio update(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    public void delete(int id) {
        laboratorioRepository.deleteById(id);
    }

    @Override
    public Laboratorio read(int id) {
        return laboratorioRepository.findById(id).get();
    }

    @Override
    public List<Laboratorio> readAll() {
        return laboratorioRepository.findAll();
    }
    
    
}
