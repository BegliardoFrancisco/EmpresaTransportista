package com.example.TrabajoPracticoBackend.Services;

import java.lang.System.Logger.Level;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrabajoPracticoBackend.Entities.Contenedor;
import com.example.TrabajoPracticoBackend.Entities.Contenedor.Estados;
import com.example.TrabajoPracticoBackend.Repositories.ContenedorRepository;



@Service
public class ContenedorService {

    @Autowired
    private ContenedorRepository contenedorRepository;


    public Contenedor addContenedor(Contenedor contenedor) {
        return contenedorRepository.save(contenedor);
    }

    public Contenedor updateEstadoContenedor(Long id, Estados estado) {
        
        Contenedor existingContenedor = contenedorRepository
        .findById(id).orElseThrow(() -> 
        new NoSuchElementException("Contenedor not found with id: " + id));
        
        existingContenedor.setEstado(estado);
        return contenedorRepository.save(existingContenedor);

    }

    public Contenedor getContenedorById(Long id) {
        return contenedorRepository.findById(id).orElse(null);
    }

    public List<Contenedor> getall() {
        return contenedorRepository.findAll();
    }

    public void deleteContenedor(Long id) {
        contenedorRepository.deleteById(id);
    }

}
