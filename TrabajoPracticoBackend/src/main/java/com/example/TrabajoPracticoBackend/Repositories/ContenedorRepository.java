package com.example.TrabajoPracticoBackend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TrabajoPracticoBackend.Entities.Contenedor;

@Repository
public interface ContenedorRepository extends JpaRepository<Contenedor, Long> {
   

    // CONSULTAR TODOS LOS CONTENDORES PENDIENTES DE ENTREGA 
    @Query("SELECT c FROM Contenedor c WHERE c.estado <> 'ENTREGADO_EN_DESTINO'")
    List<Contenedor> findContenedorPendiente();


    // CONSULTAR CONTENEDORES DEL CLIENTE
    List<Contenedor> findByClienteId(Long clienteId);

}
