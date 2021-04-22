package co.com.softka.softkau.ddd.domain.solicitante;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.solicitante.events.SolicitanteCreado;

public class SolicitanteChange extends EventChange {
    public SolicitanteChange(Solicitante solicitante){

        apply((SolicitanteCreado event) -> {
            solicitante.nombre= event.nombre();
            solicitante.estado = event.estado();
            solicitante.prioridad = event.prioridad();
            solicitante.fechaSancion = event.fechaSancion();
        });

    }
}
