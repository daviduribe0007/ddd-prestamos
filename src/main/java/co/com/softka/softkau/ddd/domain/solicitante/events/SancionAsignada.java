package co.com.softka.softkau.ddd.domain.solicitante.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.solicitante.values.FechaSancion;

import java.util.Calendar;

public class SancionAsignada extends DomainEvent {
    private final FechaSancion fechaSancion;

    public SancionAsignada(FechaSancion fechaSancion) {
        super("ddd.solicitante.sancionasignada");
        this.fechaSancion = fechaSancion;
    }

    public FechaSancion fechaSancion() {
        return fechaSancion;
    }
}
