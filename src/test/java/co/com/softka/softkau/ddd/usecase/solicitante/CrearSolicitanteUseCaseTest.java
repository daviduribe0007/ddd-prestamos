package co.com.softka.softkau.ddd.usecase.solicitante;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.solicitante.commands.CrearSolicitante;
import co.com.softka.softkau.ddd.domain.solicitante.events.SolicitanteCreado;
import co.com.softka.softkau.ddd.domain.solicitante.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


class CrearSolicitanteUseCaseTest {

    @Test
    void crearSolicitante(){
        var solicitanteId = new SolicitanteId().of("1234");
        var nombre = new Nombre("David");
        var Estado = new Estado(true);
        var prioridad = new Prioridad(0);
        Calendar fechaSancion = new GregorianCalendar(2026,9,9);


        var command = new CrearSolicitante(solicitanteId,nombre,
                Estado,prioridad,new FechaSancion(fechaSancion));
        var useCase = new CrearSolicitanteUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        SolicitanteCreado solicitanteCreado = (SolicitanteCreado) events.get(0);
        var fecha = solicitanteCreado.fechaSancion().value();

        Assertions.assertEquals("1234",solicitanteCreado.aggregateRootId());
        Assertions.assertEquals("David",solicitanteCreado.nombre().value());
        Assertions.assertEquals(true ,solicitanteCreado.estado().value());
        Assertions.assertEquals(0,solicitanteCreado.prioridad().value());
        Assertions.assertEquals(2026,fecha.get(Calendar.YEAR));
        Assertions.assertEquals(9,fecha.get(Calendar.MONTH));
        Assertions.assertEquals(9,fecha.get(Calendar.DAY_OF_MONTH));

    }

    @Test
    void crearSolicitanteNoValido() {
        var solicitanteId = new SolicitanteId().of("1234");
        var nombre = new Nombre("David");
        var Estado = new Estado(true);
        var prioridad = new Prioridad(0);
        Calendar fechaSancion = new GregorianCalendar(1000, 9, 9);


        var command = new CrearSolicitante(solicitanteId, nombre,
                Estado, prioridad, new FechaSancion(fechaSancion));
        var useCase = new CrearSolicitanteUseCase();



        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        }, "El valor de la fecha de sancion no puede ser posterior a la fecha presente");

    }
}