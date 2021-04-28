package co.com.softka.softkau.ddd.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.prestamo.commands.CrearPrestamo;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoCreado;
import co.com.softka.softkau.ddd.domain.prestamo.values.*;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


class CrearPrestamoUseCaseTest {

    @Test
    void CrearPrestamo(){
        var prestamoId = PrestamoId.of("1");
        var implementoId = ImplementoId.of("111");
        var solicitanteId = SolicitanteId.of("1");
        var estadoPrestamo = new EstadoPrestamo(true);
        var entregado = new Entregado(true);
        Calendar fechaprestamo = new GregorianCalendar(2026,9,9,12,30);
        Calendar fechaRetorno = new GregorianCalendar(2026,9,9,16,30);

        var command = new CrearPrestamo(prestamoId,implementoId,solicitanteId,estadoPrestamo,entregado,
                new FechaPrestamo(fechaprestamo),new FechaRetorno(fechaRetorno));
        var useCase = new CrearPrestamoUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        PrestamoCreado prestamoCreado = (PrestamoCreado) events.get(0);

        var fechaPres = prestamoCreado.fechaPrestamo().value();
        var fechaReto = prestamoCreado.fechaRetorno().value();
        Assertions.assertEquals("1",prestamoCreado.aggregateRootId().toString());
        Assertions.assertEquals("111",prestamoCreado.implementoId().value());
        Assertions.assertEquals("1" ,prestamoCreado.solicitanteId().value().toString());
        Assertions.assertEquals(true,prestamoCreado.estadoPrestamo().value());
        Assertions.assertEquals(true,prestamoCreado.entregado().value());
        Assertions.assertEquals(2026,fechaPres.get(Calendar.YEAR));
        Assertions.assertEquals(9,fechaPres.get(Calendar.MONTH));
        Assertions.assertEquals(9,fechaPres.get(Calendar.DAY_OF_MONTH));
        Assertions.assertEquals(12,fechaPres.get(Calendar.HOUR_OF_DAY));
        Assertions.assertEquals(30,fechaPres.get(Calendar.MINUTE));
        Assertions.assertEquals(2026,fechaReto.get(Calendar.YEAR));
        Assertions.assertEquals(9,fechaReto.get(Calendar.MONTH));
        Assertions.assertEquals(9,fechaReto.get(Calendar.DAY_OF_MONTH));
        Assertions.assertEquals(16,fechaReto.get(Calendar.HOUR_OF_DAY));
        Assertions.assertEquals(30,fechaReto.get(Calendar.MINUTE));


    }

}