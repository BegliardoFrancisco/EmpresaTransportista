package com.example.TrabajoPracticoBackend.Application.Requests;

import com.example.TrabajoPracticoBackend.Entities.Contenedor.Estados;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActualizaEstadoContenedorRequest {

    Long id;
    Estados nuevoEstado;
}