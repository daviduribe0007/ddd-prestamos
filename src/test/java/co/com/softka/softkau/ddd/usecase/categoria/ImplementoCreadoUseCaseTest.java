package co.com.softka.softkau.ddd.usecase.categoria;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.commands.CrearImplemento;
import co.com.softka.softkau.ddd.domain.categoria.events.CategoriaCreada;
import co.com.softka.softkau.ddd.domain.categoria.events.ImplementoCreado;
import co.com.softka.softkau.ddd.domain.categoria.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplementoCreadoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearImplemento() {
        var categoriaId = CategoriaId.of("1");
        var descripcion = new Descripcion("Equipos de  Computo");
        var implementoId = ImplementoId.of("111");
        var tipo = new Tipo("Mac");
        var descripcionImplemento = new Descripcion("Computador de 17 muy bueno");
        var CodigoBarras = new CodigoBarras("111222");
        var estadoImplemento = new EstadoImplemento("PerfectoEstado");
        var extraible = new Extraible(true);
        var prestamo = new Prestamo(false);
        var command = new CrearImplemento(categoriaId,implementoId,tipo,descripcionImplemento,CodigoBarras,
                estadoImplemento,extraible,prestamo);
        var useCase  = new ImplementoCreadoUseCase();

        when(repository.getEventsBy(categoriaId.value())).thenReturn(eventStored(categoriaId,descripcion));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(categoriaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ImplementoCreado) events.get(0);


        Assertions.assertEquals("111", event.implementoId().value());
        Assertions.assertEquals("Mac", event.tipo().value());
        Assertions.assertEquals("Computador de 17 muy bueno", event.descripcionImplemento().value());
        Assertions.assertEquals("111222", event.codigoBarras().value());
        Assertions.assertEquals("PerfectoEstado", event.estadoImplemento().value());
        Assertions.assertEquals(true , event.extraible().value());
        Assertions.assertEquals(false,event.prestamo().value());
    }

    private List<DomainEvent> eventStored(CategoriaId categoriaId, Descripcion descripcion) {

        return List.of(
                new CategoriaCreada(categoriaId, descripcion)
        );
    }

}