/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Presentacion;
import java.util.List;

/**
 *
 * @author javier_gr
 */
public interface PresentacionService {
    Presentacion create(Presentacion presentacion);
    Presentacion update(Presentacion presentacion);
    void delete(int id);
    Presentacion read(int id);
    List<Presentacion> readAll();
    
}
