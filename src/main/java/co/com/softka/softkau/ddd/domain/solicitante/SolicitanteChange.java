package co.com.softka.softkau.ddd.domain.solicitante;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.solicitante.events.PrioridadBajada;
import co.com.softka.softkau.ddd.domain.solicitante.events.SancionAsignada;
import co.com.softka.softkau.ddd.domain.solicitante.events.SolicitanteCreado;
import co.com.softka.softkau.ddd.domain.solicitante.events.PrioridadSubida;

public class SolicitanteChange extends EventChange {
    public SolicitanteChange(Solicitante solicitante) {

        apply((SolicitanteCreado event) -> {
            solicitante.nombre = event.nombre();
            solicitante.estado = event.estado();
            solicitante.prioridad = event.prioridad();
            solicitante.fechaSancion = event.fechaSancion();
        });

        apply((PrioridadSubida event) -> {
            solicitante.prioridad = event.prioridad().aumentar();
        });

        apply((PrioridadBajada event) -> {
            solicitante.prioridad = event.prioridad().disminuir();
        });

        apply((SancionAsignada event) -> {
            solicitante.fechaSancion = event.fechaSancion();
        });
    }
}
