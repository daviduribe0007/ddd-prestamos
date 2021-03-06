package co.com.softka.softkau.ddd.domain.prestamo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.Categoria;
import co.com.softka.softkau.ddd.domain.categoria.values.CategoriaId;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoCreado;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoRetornado;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoSolicitado;
import co.com.softka.softkau.ddd.domain.prestamo.events.SolicitudPrestamoCancelado;
import co.com.softka.softkau.ddd.domain.prestamo.values.*;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

import java.util.List;
import java.util.Map;

public class Prestamo extends AggregateEvent<PrestamoId> {

    protected ImplementoId implementoId;
    protected Map<CategoriaId, Categoria> categoriaMap;
    protected SolicitanteId solicitanteId;
    protected EstadoPrestamo estadoPrestamo;
    protected Entregado entregado;
    protected FechaPrestamo fechaPrestamo;
    protected FechaRetorno fechaRetorno;


public Prestamo(PrestamoId entityId, ImplementoId implementoId,
                    SolicitanteId solicitanteId, EstadoPrestamo estadoPrestamo, Entregado entregado,
                    FechaPrestamo fechaPrestamo, FechaRetorno fechaRetorno) {
        super(entityId);
        this.implementoId = implementoId;
        if (entregado.value().equals(false)){
            appendChange(new PrestamoSolicitado(implementoId, solicitanteId, estadoPrestamo,
                    entregado, fechaPrestamo, fechaRetorno)).apply();
        }else {
            appendChange(new PrestamoCreado(implementoId, solicitanteId, estadoPrestamo,
                    entregado, fechaPrestamo, fechaRetorno)).apply();
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

    public void retornarPrestamo(EstadoPrestamo estadoPrestamo,Entregado entregado, FechaRetorno fechaRetorno){
        appendChange(new PrestamoRetornado(estadoPrestamo,entregado,fechaRetorno)).apply();
    }
    public void cancelarSolicitudPrestamo(EstadoPrestamo estadoPrestamo){
        appendChange(new SolicitudPrestamoCancelado(estadoPrestamo)).apply();
    }





}
