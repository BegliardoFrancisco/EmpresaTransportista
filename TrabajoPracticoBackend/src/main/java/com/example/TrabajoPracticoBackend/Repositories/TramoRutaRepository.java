package com.example.TrabajoPracticoBackend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TrabajoPracticoBackend.Entities.TramoRuta;

@Repository
public interface TramoRutaRepository extends JpaRepository<TramoRuta, Long> {
    


    @Query("SELECT t FROM TramoRuta t WHERE t.solicitud_id LIKE :id")
    List<TramoRuta> findTramosBySolicitud(@Param("id") Long solicitud_id);

}