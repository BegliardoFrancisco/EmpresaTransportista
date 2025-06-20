package com.example.TrabajoPracticoBackend.Services;

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


    public Contenedor AgregarContenedor(Contenedor contenedor) {
        return contenedorRepository.save(contenedor);
    }

    public Contenedor ActualizarEstadoContenedor(Long id, Estados estado) {
        
        Contenedor existingContenedor = contenedorRepository
        .findById(id).orElseThrow(() -> 
        new NoSuchElementException("Contenedor not found with id: " + id));
        
        existingContenedor.setEstado(estado);
        return contenedorRepository.save(existingContenedor);

    }

    public Contenedor ObtenerContenedorPorId(Long id) {
        return contenedorRepository.findById(id).orElse(null);
    }

    public List<Contenedor> ObtenerTodos() {
        return contenedorRepository.findAll();
    }

    public List<Contenedor> ObtenerContenedoresDelCliente(Long clienteId) {
        return contenedorRepository.findByClienteId(clienteId);
    }

    public List<Contenedor> ObtenerContenedoresPendientes() {
        return contenedorRepository.findContenedorPendiente();
    }

    public void EliminarContenedorPorId(Long id) {
        contenedorRepository.deleteById(id);
    }

}
