package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.categoria.values.Prestamo;

public class ImplementoSolicitado extends DomainEvent {

    private final ImplementoId implementoId;
    private final Boolean prestamo;

    public ImplementoSolicitado(ImplementoId implementoId, boolean prestamo) {
        super("ddd.categoria.implementosolicitado");
        this.implementoId = implementoId;
        this.prestamo = prestamo;
    }

    public ImplementoId implementoId() {
        return implementoId;
    }

    public Boolean prestamo() {
        return prestamo;
    }
}
