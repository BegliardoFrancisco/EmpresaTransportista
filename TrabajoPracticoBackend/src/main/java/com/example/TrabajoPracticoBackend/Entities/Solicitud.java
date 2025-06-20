package com.example.TrabajoPracticoBackend.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ...código existente...
@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El contenedor no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contenedor_id", nullable = false)
    private Contenedor contenedor;

    @NotNull(message = "La ciudad de origen no puede ser nula")
    @Column(name = "ciudad_origen_id", nullable = false)
    private Long ciudadOrigenId;

    @NotNull(message = "La ciudad de destino no puede ser nula")
    @Column(name = "ciudad_destino_id", nullable = false)
    private Long ciudadDestinoId;

    @NotNull(message = "El depósito no puede ser nulo")
    @Column(name = "deposito_id", nullable = false)
    private Long depositoId;

    @Column(name = "camion_id", nullable = false)
    private Long camionId;

    @Column(name = "costo_estimado")
    private Double costoEstimado;

    @Column(name = "tiempo_estimado_horas")
    private Double tiempoEstimadoHoras;

}