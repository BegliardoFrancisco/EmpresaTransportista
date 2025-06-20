package com.example.TrabajoPracticoBackend.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.TrabajoPracticoBackend.Entities.TramoRuta;

@Repository
public interface TramoRutaRepository extends JpaRepository<TramoRuta, Long> {
    

}