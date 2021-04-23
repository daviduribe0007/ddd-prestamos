package co.com.softka.softkau.ddd.domain.prestamo;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.prestamo.Prestamo;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoCreado;

public class prestamoChange extends EventChange {
    public prestamoChange(Prestamo prestamo) {

        apply((PrestamoCreado event) -> {
            prestamo.inventarioId = event.inventarioId();
            prestamo.solicitanteId = event.solicitanteId();
            prestamo.estado = event.estado();
            prestamo.fechaPrestamo = event.fechaPrestamo();
            prestamo.fechaCancelacion = event.fechaCancelacion();
        });
    }
}
