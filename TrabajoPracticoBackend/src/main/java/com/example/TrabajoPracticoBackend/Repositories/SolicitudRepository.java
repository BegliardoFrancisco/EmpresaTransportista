package com.example.TrabajoPracticoBackend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TrabajoPracticoBackend.Entities.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    // CONSULTAR SOLICITUDES DEL CLIENTE
    @Query("SELECT s FROM Solicitud s JOIN s.contenedor c WHERE c.cliente.id = :id")
    List<Solicitud> findSolicitudByClienteId(@Param("id") Long clienteId);

    // CONSULTAR SOLICITUD DEL CLIENTE
    @Query("SELECT s FROM Solicitud s JOIN Contenedor c ON s.contenedor.id = c.id WHERE c.cliente.id = :Cid")
    Solicitud findSolicitudDeClientePorId(@Param("Cid") Long clienteId);
}   