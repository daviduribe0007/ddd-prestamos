package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.values.EstadoImplemento;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;

import java.util.Calendar;

public class ImplementoRetornado extends DomainEvent {

    private final ImplementoId implementoId;
    private final String estadoImplemento;
    private final boolean prestamo;
    private final Calendar fechaRetorno;

    public ImplementoRetornado(ImplementoId implementoId, String estadoImplemento,
                               boolean prestamo, Calendar fechaRetorno) {
        super("ddd.categoria.implementoretornado");
        this.implementoId = implementoId;
        this.estadoImplemento = estadoImplemento;
        this.prestamo = prestamo;
        this.fechaRetorno = fechaRetorno;
    }

    public ImplementoId implementoId() {
        return implementoId;
    }

    public String estadoImplemento() {
        return estadoImplemento;
    }

    public boolean prestamo() {
        return prestamo;
    }

    public Calendar fechaRetorno() {
        return fechaRetorno;
    }
}
