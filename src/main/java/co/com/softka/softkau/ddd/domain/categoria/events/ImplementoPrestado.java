package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;

import java.util.Calendar;

public class ImplementoPrestado extends DomainEvent {

    private final ImplementoId implementoId;
    private final boolean prestamo;
    private final Calendar fechaRetorno;

    public ImplementoPrestado(ImplementoId implementoId, boolean prestamo, Calendar fechaRetorno) {
        super("ddd.categoria.implementoprestado");
        this.implementoId = implementoId;
        this.prestamo = prestamo;
        this.fechaRetorno = fechaRetorno;
    }

    public ImplementoId implementoId() {
        return implementoId;
    }

    public boolean prestamo() {
        return prestamo;
    }

    public Calendar fechaRetorno() {
        return fechaRetorno;
    }
}
