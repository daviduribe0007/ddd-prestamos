package co.com.softka.softkau.ddd.domain.prestamo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.softka.softkau.ddd.domain.inventario.values.InventarioId;
import co.com.softka.softkau.ddd.domain.prestamo.values.Estado;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaCancelacion;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaPrestamo;
import co.com.softka.softkau.ddd.domain.prestamo.values.PrestamoId;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

public class Prestamo extends AggregateEvent<PrestamoId> {

    protected InventarioId inventarioId;
    protected SolicitanteId solicitanteId;
    protected Estado estado;
    protected FechaPrestamo fechaPrestamo;
    protected FechaCancelacion fechaCancelacion;

    public Prestamo(PrestamoId entityId, InventarioId inventarioId, SolicitanteId solicitanteId, Estado estado, FechaCancelacion fechaCancelacion) {
        super(entityId);
        this.inventarioId = inventarioId;
        this.solicitanteId = solicitanteId;
        this.estado = estado;
        this.fechaCancelacion = fechaCancelacion;
    }
}
