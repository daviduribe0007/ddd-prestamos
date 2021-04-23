package co.com.softka.softkau.ddd.domain.solicitante.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.solicitante.values.Estado;
import co.com.softka.softkau.ddd.domain.solicitante.values.FechaSancion;
import co.com.softka.softkau.ddd.domain.solicitante.values.Nombre;
import co.com.softka.softkau.ddd.domain.solicitante.values.Prioridad;

public class SolicitanteCreado extends DomainEvent {
    private final Nombre nombre;
    private final Estado estado;
    private final Prioridad prioridad;
    private final FechaSancion fechaSancion;

    public SolicitanteCreado( Nombre nombre, Estado estado, Prioridad prioridad,
                              FechaSancion fechaSancion) {
        super("ddd.solicitante.creado");
        this.nombre = nombre;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaSancion = fechaSancion;
    }



    public Nombre nombre() {
        return nombre;
    }

    public Estado estado() {
        return estado;
    }

    public Prioridad prioridad() {
        return prioridad;
    }

    public FechaSancion fechaSancion() {
        return fechaSancion;
    }
}
