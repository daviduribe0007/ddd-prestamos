package co.com.softka.softkau.ddd.domain.prestamo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.inventario.Inventario;
import co.com.softka.softkau.ddd.domain.inventario.values.InventarioId;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoCreado;
import co.com.softka.softkau.ddd.domain.prestamo.values.Estado;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaCancelacion;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaPrestamo;
import co.com.softka.softkau.ddd.domain.prestamo.values.PrestamoId;
import co.com.softka.softkau.ddd.domain.solicitante.Solicitante;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

import java.util.List;
import java.util.Map;

public class Prestamo extends AggregateEvent<PrestamoId> {

    protected Map<InventarioId, Inventario> inventarioMap;
    protected SolicitanteId solicitanteId;
    protected Estado estado;
    protected FechaPrestamo fechaPrestamo;
    protected FechaCancelacion fechaCancelacion;



    public Prestamo(PrestamoId entityId, Map<InventarioId, Inventario> inventarioMap, SolicitanteId solicitanteId,
                    Estado estado, FechaPrestamo fechaPrestamo, FechaCancelacion fechaCancelacion) {
        super(entityId);
        appendChange(new PrestamoCreado(inventarioMap,solicitanteId,estado,fechaPrestamo,fechaCancelacion)).apply();
    }

    private Prestamo(PrestamoId entityId) {
        super(entityId);
        subscribe(new PrestamoChange(this));
    }

    public static Prestamo from (PrestamoId entityId, List<DomainEvent> events){
        var prestamo = new Prestamo(entityId);
        events.forEach(prestamo::applyEvent);
        return prestamo;
    }




}
