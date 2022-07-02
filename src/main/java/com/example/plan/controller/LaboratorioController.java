/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import com.example.plan.entity.Laboratorio;
import com.example.plan.serviceImpl.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author javier_gr
 */
@Controller
@RequestMapping("/laboratorio")
public class LaboratorioController {
    @Autowired
    private LaboratorioService laboratorioService;
    
    @GetMapping
    public String indexLaboratorio(Model model){
        model.addAttribute("laboratorios", laboratorioService.readAll());
        return "laboratorios/listarLaboratorio";
    }
    @GetMapping("/add")
    public String addLaboratorio(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("laboratorio", new Laboratorio());
        return "laboratorios/addLaboratorio";
    }
    @GetMapping("/save")
    public String saveLaboratorio(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("laboratorio", new Laboratorio());
        return "laboratorios/addLaboratorio";
    }
    @PostMapping("/save")
    public String addLaboratorio(@Valid @ModelAttribute Laboratorio laboratorio, BindingResult result, Model model, RedirectAttributes attributes ) {  
        laboratorioService.create(laboratorio);
        return "redirect:/laboratorios";
    }
    @GetMapping("/edit/{id}")
    public String editarLaboratorio(@PathVariable("id") int idlaboratorio, Model model) {  
        Laboratorio laboratorio = laboratorioService.read(idlaboratorio);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("laboratorio", laboratorio);
        return "laboratorios/addLaboratorio";
    }
    @GetMapping("/detalle/{id}")
    public String detalleLaboratorio(@PathVariable("id") int idlaboratorio, Model model) {
        
        Laboratorio laboratorio = laboratorioService.read(idlaboratorio);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("producto", laboratorio);
        return "productos/detalleLaboratorio";
    }
    @GetMapping("/delete/{id}")
    public String deleteLaboratorio(@PathVariable("id") int idlaboratorio) {  
       laboratorioService.delete(idlaboratorio);
        return "redirect:/laboratorio";
    }
}
