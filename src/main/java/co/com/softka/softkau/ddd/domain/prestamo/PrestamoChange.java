package co.com.softka.softkau.ddd.domain.prestamo;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoCreado;

public class PrestamoChange extends EventChange {
    public PrestamoChange(Prestamo prestamo) {

        apply((PrestamoCreado event) -> {
            prestamo.inventarioMap = event.inventarioMap();
            prestamo.solicitanteId = event.solicitanteId();
            prestamo.estadoPrestamo = event.estado();
            prestamo.entregado = event.entregado();
            prestamo.fechaPrestamo = event.fechaPrestamo();
            prestamo.fechaCancelacion = event.fechaCancelacion();
        });
    }
}
