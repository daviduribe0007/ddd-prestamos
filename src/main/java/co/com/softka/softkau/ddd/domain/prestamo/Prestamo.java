package co.com.softka.softkau.ddd.domain.prestamo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.inventario.Inventario;
import co.com.softka.softkau.ddd.domain.inventario.values.InventarioId;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoCreado;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoSolicitado;
import co.com.softka.softkau.ddd.domain.prestamo.values.*;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

import java.util.List;
import java.util.Map;

public class Prestamo extends AggregateEvent<PrestamoId> {

    protected Map<InventarioId, Inventario> inventarioMap;
    protected SolicitanteId solicitanteId;
    protected EstadoPrestamo estadoPrestamo;
    protected Entregado entregado;
    protected FechaPrestamo fechaPrestamo;
    protected FechaCancelacion fechaCancelacion;


    public Prestamo(PrestamoId entityId, Map<InventarioId, Inventario> inventarioMap,
                    SolicitanteId solicitanteId, EstadoPrestamo estadoPrestamo, Entregado entregado,
                    FechaPrestamo fechaPrestamo, FechaCancelacion fechaCancelacion) {
        super(entityId);
        if (entregado.value().equals(false)){
            appendChange(new PrestamoSolicitado(inventarioMap, solicitanteId, estadoPrestamo,
                    entregado, fechaPrestamo, fechaCancelacion)).apply();
        }else {
            appendChange(new PrestamoCreado(inventarioMap, solicitanteId, estadoPrestamo,
                    entregado, fechaPrestamo, fechaCancelacion)).apply();
        }
    }

    private Prestamo(PrestamoId entityId) {
        super(entityId);
        subscribe(new PrestamoChange(this));
    }

    public static Prestamo from(PrestamoId entityId, List<DomainEvent> events) {
        var prestamo = new Prestamo(entityId);
        events.forEach(prestamo::applyEvent);
        return prestamo;
    }


}
