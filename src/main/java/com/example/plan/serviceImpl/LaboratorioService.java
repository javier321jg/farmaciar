/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Laboratorio;
import java.util.List;

/**
 *
 * @author javier_gr
 */
public interface LaboratorioService {
    Laboratorio create(Laboratorio laboratorio);
    Laboratorio update(Laboratorio laboratorio);
    void delete(int id);
    Laboratorio read(int id);
    List<Laboratorio> readAll();
    
}
