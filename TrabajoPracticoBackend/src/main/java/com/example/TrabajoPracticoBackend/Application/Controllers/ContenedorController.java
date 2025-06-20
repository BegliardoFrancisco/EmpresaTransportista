package com.example.TrabajoPracticoBackend.Application.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrabajoPracticoBackend.Application.Requests.ActualizaEstadoContenedorRequest;
import com.example.TrabajoPracticoBackend.Application.Requests.ActualizarContenedorRequest;
import com.example.TrabajoPracticoBackend.Entities.Contenedor;
import com.example.TrabajoPracticoBackend.Entities.Contenedor.Estados;
import com.example.TrabajoPracticoBackend.Services.ContenedorService;

@RestController
@RequestMapping("/contenedor")
public class ContenedorController {

    @Autowired
    private ContenedorService contenedorService;


    @GetMapping
    public List<Contenedor> findall() {
        return this.contenedorService.getall();   
    } 

    @GetMapping("/{id}")
    public Contenedor findbyid(@PathVariable Long id) {return this.contenedorService.getContenedorById(id);}


    @PostMapping
    public Contenedor create(@RequestBody Contenedor contenedor){
        return this.contenedorService.addContenedor(contenedor);
    }

    @PatchMapping
    public Contenedor updateEstado(@RequestBody ActualizaEstadoContenedorRequest contenedor){
        
        Long idContenedor = contenedor.getId();
        Estados nuevoEstado = contenedor.getNuevoEstado();
        
        
        return this.contenedorService.updateEstadoContenedor(idContenedor, nuevoEstado); 
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.contenedorService.deleteContenedor(id);
    }


}
