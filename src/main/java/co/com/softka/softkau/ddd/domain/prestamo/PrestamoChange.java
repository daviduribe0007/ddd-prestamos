package co.com.softka.softkau.ddd.domain.prestamo;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoCreado;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoSolicitado;

public class PrestamoChange extends EventChange {
    public PrestamoChange(Prestamo prestamo) {

        apply((PrestamoSolicitado event) -> {
            prestamo.inventarioMap = event.inventarioMap();
            prestamo.solicitanteId = event.solicitanteId();
            prestamo.estadoPrestamo = event.estadoPrestamo();
            prestamo.entregado = event.entregado();
            prestamo.fechaPrestamo = event.fechaPrestamo();
            prestamo.fechaCancelacion = event.fechaCancelacion();
        });

        apply((PrestamoCreado event) -> {
            prestamo.inventarioMap = event.inventarioMap();
            prestamo.solicitanteId = event.solicitanteId();
            prestamo.estadoPrestamo = event.estadoPrestamo();
            prestamo.entregado = event.entregado();
            prestamo.fechaPrestamo = event.fechaPrestamo();
            prestamo.fechaCancelacion = event.fechaCancelacion();
        });


    }
}
