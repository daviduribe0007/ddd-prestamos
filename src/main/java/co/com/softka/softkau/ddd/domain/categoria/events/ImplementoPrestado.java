package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;

import java.util.Calendar;

public class ImplementoPrestado extends DomainEvent {

    private final ImplementoId implementoId;
    private final boolean prestamo;
    private final Calendar fechaRiempoPrestamo;

    public ImplementoPrestado(ImplementoId implementoId, boolean prestamo, Calendar fechaRiempoPrestamo) {
        super("ddd.categoria.implementoprestado");
        this.implementoId = implementoId;
        this.prestamo = prestamo;
        this.fechaRiempoPrestamo = fechaRiempoPrestamo;
    }

    public ImplementoId implementoId() {
        return implementoId;
    }

    public boolean prestamo() {
        return prestamo;
    }

    public Calendar fechaTiempoPrestamo() {
        return fechaRiempoPrestamo;
    }
}
