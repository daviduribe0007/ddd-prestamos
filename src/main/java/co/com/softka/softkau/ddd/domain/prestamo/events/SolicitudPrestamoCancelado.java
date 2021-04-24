package co.com.softka.softkau.ddd.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.prestamo.values.Entregado;
import co.com.softka.softkau.ddd.domain.prestamo.values.EstadoPrestamo;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaRetorno;

public class SolicitudPrestamoCancelado extends DomainEvent {

    private final EstadoPrestamo estadoPrestamo;


    public SolicitudPrestamoCancelado(EstadoPrestamo estadoPrestamo) {
        super("ddd.prestamo.solicitudprestamocancelada");
        this.estadoPrestamo = estadoPrestamo;
    }

    public EstadoPrestamo estadoPrestamo() {
        return estadoPrestamo;
    }
}
