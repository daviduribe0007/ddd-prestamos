package co.com.softka.softkau.ddd.domain.solicitante;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.solicitante.events.PrioridadBajada;
import co.com.softka.softkau.ddd.domain.solicitante.events.SancionAsignada;
import co.com.softka.softkau.ddd.domain.solicitante.events.SolicitanteCreado;
import co.com.softka.softkau.ddd.domain.solicitante.events.PrioridadSubida;
import co.com.softka.softkau.ddd.domain.solicitante.values.*;

import java.util.List;

public class Solicitante extends AggregateEvent<SolicitanteId> {

    protected Nombre nombre;
    protected Estado estado;
    protected Prioridad prioridad;
    protected FechaSancion fechaSancion;

    public Solicitante(SolicitanteId entityId, Nombre nombre, Estado estado, Prioridad prioridad, FechaSancion fechaSancion) {
        super(entityId);
        appendChange(new SolicitanteCreado(nombre, estado, prioridad, fechaSancion)).apply();
    }

    private Solicitante(SolicitanteId entityId) {
        super(entityId);
        subscribe(new SolicitanteChange(this));
    }

    public static Solicitante from(SolicitanteId entityId, List<DomainEvent> events) {
        var solicitante = new Solicitante(entityId);
        events.forEach(solicitante::applyEvent);
        return solicitante;
    }

    public void subirPrioridad(Prioridad prioridad) {
        appendChange(new PrioridadSubida(prioridad)).apply();
    }

    public void bajarPrioridad(Prioridad prioridad) {
        appendChange(new PrioridadBajada(prioridad)).apply();
    }

    public void asignarSancion(FechaSancion fechaSancion){
        appendChange(new SancionAsignada(fechaSancion)).apply();
    }

    public Boolean isSolicitanteActivo() {
        return estado.value();
    }
}
