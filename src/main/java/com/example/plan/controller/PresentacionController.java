
package com.example.plan.controller;
import com.example.plan.entity.Presentacion;
import com.example.plan.serviceImpl.PresentacionService;
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
@RequestMapping("/presentacion")
public class PresentacionController {
@Autowired
private PresentacionService presentacionService;
@GetMapping
public String indexPresentacion (Model model){
        model.addAttribute("presentaciones", presentacionService.readAll());
        return "presentaciones/listarPresentacion";
    }
 @GetMapping("/add")
    public String addPresentacion(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("presentacion", new Presentacion());
        return "presentaciones/addPresentacion";
    }
@GetMapping("/save")
    public String savePresentacion(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("presentacion", new Presentacion());
        return "presentacion/addPresentacion";
    }    
@PostMapping("/save")
    public String addPresentacion(@Valid @ModelAttribute Presentacion presentacion, BindingResult result, Model model, RedirectAttributes attributes ) {  
        presentacionService.create(presentacion);
        return "redirect:/presentacion";
    }
    @GetMapping("/edit/{id}")
    public String editarPresentacion(@PathVariable("id") int idpresentacion, Model model) {  
        Presentacion presentacion = presentacionService.read(idpresentacion);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("presentacion", presentacion);
        return "presentaciones/addPresentacion";
    }
    @GetMapping("/detalle/{id}")
    public String detallePresentacion(@PathVariable("id") int idpresentacion, Model model) {
        
        Presentacion presentacion = presentacionService.read(idpresentacion);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("producto", presentacion);
        return "productos/detallePresentacion";
    }
    @GetMapping("/delete/{id}")
    public String deletePresentacion(@PathVariable("id") int idpresentacion) {  
       presentacionService.delete(idpresentacion);
        return "redirect:/presentacion";
    }    
}
