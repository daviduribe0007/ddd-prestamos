package co.com.softka.softkau.ddd.domain.solicitante;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.softka.softkau.ddd.domain.solicitante.values.*;

public class Solicitante extends AggregateEvent<SolicitanteId> {

    protected final Nombre nombre;
    protected Estado estado;
    protected Prioridad prioridad;
    protected FechaSancion fechaSancion;

    public Solicitante(SolicitanteId entityId, Nombre nombre, Estado estado, Prioridad prioridad, FechaSancion fechaSancion) {
        super(entityId);
        this.nombre = nombre;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaSancion = fechaSancion;
    }

    
}
