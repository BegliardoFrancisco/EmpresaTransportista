package com.example.TrabajoPracticoBackend.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import io.micrometer.common.lang.Nullable;


@Entity
@Table(name = "tramo_ruta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TramoRuta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @NotNull(message = "El orden no puede ser nulo")
    @Column(name = "orden", nullable = false)
    private Integer orden;

    @NotNull(message = "El tipo de tramo no puede ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tramo", length = 30, nullable = false)
    private TipoTramo tipoTramo;

    @NotNull(message = "La ciudad de origen del tramo no puede ser nula")
    @Column(name = "ciudad_origen_id", nullable = false)
    private long ciudadOrigen;

    @NotNull(message = "La ciudad de destino del tramo no puede ser nula")
    @Column(name = "ciudad_destino_id", nullable = false)
    private long ciudadDestino;

    @Nullable
    @Column(name = "fecha_estimada_salida")
    private LocalDateTime fechaEstimadaSalida;

    @Nullable
    @Column(name = "fecha_estimada_llegada")
    private LocalDateTime fechaEstimadaLlegada;

    @Nullable
    @Column(name = "fecha_real_salida")
    private LocalDateTime fechaRealSalida;

    @Nullable
    @Column(name = "fecha_real_llegada")
    private LocalDateTime fechaRealLlegada;

    public enum TipoTramo {
        ORIGEN_DEP,
        DEP_DESTINO
    }
}