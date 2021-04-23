package co.com.softka.softkau.ddd.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.prestamo.values.Entregado;
import co.com.softka.softkau.ddd.domain.prestamo.values.EstadoPrestamo;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaRetorno;

public class PrestamoRetornado extends DomainEvent {

    private final EstadoPrestamo estadoPrestamo;
    private final Entregado entregado;
    private final FechaRetorno fechaRetorno;

    public PrestamoRetornado(EstadoPrestamo estadoPrestamo, Entregado entregado, FechaRetorno fechaRetorno) {
        super("ddd.prestamo.retornado");
        this.estadoPrestamo = estadoPrestamo;
        this.entregado = entregado;
        this.fechaRetorno = fechaRetorno;
    }

    public EstadoPrestamo estadoPrestamo() {
        return estadoPrestamo;
    }

    public Entregado entregado() {
        return entregado;
    }

    public FechaRetorno fechaRetorno() {
        return fechaRetorno;
    }
}
