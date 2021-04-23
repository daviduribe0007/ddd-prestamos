package co.com.softka.softkau.ddd.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.inventario.values.InventarioId;
import co.com.softka.softkau.ddd.domain.prestamo.values.Estado;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaCancelacion;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaPrestamo;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

public class PrestamoCreado extends DomainEvent {

    private final InventarioId inventarioId;
    private final SolicitanteId solicitanteId;
    private final Estado estado;
    private final FechaPrestamo fechaPrestamo;
    private final FechaCancelacion fechaCancelacion;

    public PrestamoCreado(InventarioId inventarioId, SolicitanteId solicitanteId, Estado estado,
                          FechaPrestamo fechaPrestamo, FechaCancelacion fechaCancelacion) {
        super("ddd.prestamo.creado");
        this.inventarioId = inventarioId;
        this.solicitanteId = solicitanteId;
        this.estado = estado;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaCancelacion = fechaCancelacion;
    }

    public InventarioId inventarioId() {
        return inventarioId;
    }

    public SolicitanteId solicitanteId() {
        return solicitanteId;
    }

    public Estado estado() {
        return estado;
    }

    public FechaPrestamo fechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaCancelacion fechaCancelacion() {
        return fechaCancelacion;
    }
}
