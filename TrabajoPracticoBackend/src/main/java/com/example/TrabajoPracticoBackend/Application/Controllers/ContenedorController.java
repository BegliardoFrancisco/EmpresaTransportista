package com.example.TrabajoPracticoBackend.Application.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrabajoPracticoBackend.Application.Requests.ActualizaEstadoContenedorRequest;
import com.example.TrabajoPracticoBackend.Entities.Contenedor;
import com.example.TrabajoPracticoBackend.Entities.Contenedor.Estados;
import com.example.TrabajoPracticoBackend.Services.ContenedorService;

@RestController
@RequestMapping("/contenedor")
public class ContenedorController {

    @Autowired
    private ContenedorService contenedorService;
    
    @PostMapping
    public Contenedor create(@RequestBody Contenedor contenedor){
        return this.contenedorService.AgregarContenedor(contenedor);
    }


    @GetMapping("/cliente/{id}")
    public List<Contenedor> findByCliente(@PathVariable Long id) {
        return this.contenedorService.ObtenerContenedoresDelCliente(id);
    }

    @GetMapping
    public List<Contenedor> findall() {
        return this.contenedorService.ObtenerTodos();   
    } 

    @GetMapping("/{id}")
    public Contenedor findbyid(@PathVariable Long id) {
        return this.contenedorService.ObtenerContenedorPorId(id);
    }

    @GetMapping("/pendientes")
    public List<Contenedor> findPendientes() {
        return this.contenedorService.ObtenerContenedoresPendientes();
    }

    @PatchMapping
    public Contenedor updateEstado(@RequestBody ActualizaEstadoContenedorRequest contenedor){
        
        Long idContenedor = contenedor.getId();
        Estados nuevoEstado = contenedor.getNuevoEstado();
        
        
        return this.contenedorService.ActualizarEstadoContenedor(idContenedor, nuevoEstado); 
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.contenedorService.EliminarContenedorPorId(id);
    }

    @GetMapping("/test")
    public String test() {
        return "ContenedorController is working!";
    }

}
