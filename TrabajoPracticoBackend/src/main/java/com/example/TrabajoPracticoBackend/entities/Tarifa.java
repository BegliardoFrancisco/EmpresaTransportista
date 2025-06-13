package com.example.TrabajoPracticoBackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarifa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El monto base no puede ser nulo")
    @Column(name = "monto_base", nullable = false)
    private Double montoBase;

    @NotNull(message = "El costo por km no puede ser nulo")
    @Column(name = "costo_km", nullable = false)
    private Double costoKm;

    @NotNull(message = "El costo por día de depósito no puede ser nulo")
    @Column(name = "costo_dia_deposito", nullable = false)
    private Double costoDiaDeposito;
}