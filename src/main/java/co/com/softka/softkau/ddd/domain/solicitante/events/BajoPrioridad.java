package co.com.softka.softkau.ddd.domain.solicitante.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.solicitante.values.Prioridad;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

public class BajoPrioridad extends DomainEvent {
    private final SolicitanteId entityId;
    private final Prioridad prioridad;

    public BajoPrioridad(SolicitanteId entityId, Prioridad prioridad) {
        super("ddd.solicitante.bajoprioridad");
        this.entityId = entityId;
        this.prioridad = prioridad;
    }

    public SolicitanteId entityId() {
        return entityId;
    }

    public Prioridad prioridad() {
        return prioridad;
    }
}
