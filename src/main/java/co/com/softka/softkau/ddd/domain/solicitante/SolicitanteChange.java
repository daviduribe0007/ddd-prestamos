package co.com.softka.softkau.ddd.domain.solicitante;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.solicitante.events.SolicitanteCreado;
import co.com.softka.softkau.ddd.domain.solicitante.events.SubioPrioridad;

public class SolicitanteChange extends EventChange {
    public SolicitanteChange(Solicitante solicitante){

        apply((SolicitanteCreado event) -> {
            solicitante.nombre= event.nombre();
            solicitante.estado = event.estado();
            solicitante.prioridad = event.prioridad();
            solicitante.fechaSancion = event.fechaSancion();
        });

        apply((SubioPrioridad event) ->{
            if(solicitante.identity().equals(event.entityId())){
                solicitante.prioridad = event.prioridad().aumentar();
            }
        });

    }
}
