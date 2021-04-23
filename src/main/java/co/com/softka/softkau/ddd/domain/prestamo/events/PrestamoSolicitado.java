package co.com.softka.softkau.ddd.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.inventario.Inventario;
import co.com.softka.softkau.ddd.domain.inventario.values.InventarioId;
import co.com.softka.softkau.ddd.domain.prestamo.values.Entregado;
import co.com.softka.softkau.ddd.domain.prestamo.values.EstadoPrestamo;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaCancelacion;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaPrestamo;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

import java.util.Map;

public class PrestamoSolicitado extends DomainEvent {

    private final Map<InventarioId, Inventario> inventarioMap;
    private final SolicitanteId solicitanteId;
    private final EstadoPrestamo estadoPrestamo;
    private final Entregado entregado;
    private final FechaPrestamo fechaPrestamo;
    private final FechaCancelacion fechaCancelacion;


    public PrestamoSolicitado(Map<InventarioId, Inventario> inventarioId, SolicitanteId solicitanteId,
                              EstadoPrestamo estadoPrestamo, Entregado entregado,
                              FechaPrestamo fechaPrestamo, FechaCancelacion fechaCancelacion) {
        super("ddd.prestamo.solicitado");
        this.inventarioMap = inventarioId;
        this.solicitanteId = solicitanteId;
        this.estadoPrestamo = estadoPrestamo;
        this.entregado = entregado;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaCancelacion = fechaCancelacion;
    }

    public Map<InventarioId, Inventario> inventarioMap() {
        return inventarioMap;
    }

    public Entregado entregado() {
        return entregado;
    }

    public SolicitanteId solicitanteId() {
        return solicitanteId;
    }

    public EstadoPrestamo estadoPrestamo() {
        return estadoPrestamo;
    }

    public FechaPrestamo fechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaCancelacion fechaCancelacion() {
        return fechaCancelacion;
    }
}