/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Producto;
import java.util.List;

/**
 *
 * @author javier_gr
 */
public interface ProductoService {
    Producto create(Producto presentacion);
    Producto update(Producto presentacion);
    void delete(int id);
    Producto read(int id);
    List<Producto> readAll();
}
