package co.com.softka.softkau.ddd.domain.solicitante.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.solicitante.values.Prioridad;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

public class PrioridadSubida extends DomainEvent {

    private final Prioridad prioridad;

    public PrioridadSubida(Prioridad prioridad) {
        super("ddd.solicitante.subioprioridad");
        this.prioridad = prioridad;
    }



    public Prioridad prioridad() {
        return prioridad;
    }
}
