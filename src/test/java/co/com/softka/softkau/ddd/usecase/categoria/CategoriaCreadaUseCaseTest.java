package co.com.softka.softkau.ddd.usecase.categoria;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.Implemento;
import co.com.softka.softkau.ddd.domain.categoria.commands.CrearCategoria;
import co.com.softka.softkau.ddd.domain.categoria.events.CategoriaCreada;
import co.com.softka.softkau.ddd.domain.categoria.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaCreadaUseCaseTest {
    @Test
    void crearCategoria() {
        var categoriaId = new CategoriaId().of("1234");
        var prestamo = new GregorianCalendar(2021, 3, 5);

        var retorno = new GregorianCalendar(2021, 3, 10);
        var categorias = Map.of(ImplementoId.of("111"), new Implemento(ImplementoId.of("1"),
                new Tipo("Mac"), new Descripcion("Computador de 17 muy bueno"),
                new CodigoBarras("111222"), new EstadoImplemento("PerfectoEstado"),
                new TiempoPrestamo(prestamo), new FechaRetorno(retorno),
                new Extraible(true), new Prestamo(false)));
        var descripcion = new Descripcion("Video beam");


        var command = new CrearCategoria(categoriaId, categorias, descripcion);
        var useCase = new CategoriaCreadaUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        CategoriaCreada event = (CategoriaCreada) events.get(0);

        Assertions.assertTrue(Objects.nonNull(event.getClass()));


        Assertions.assertEquals("1234", command.getEntityId().value());
        Assertions.assertEquals("Video beam", command.getDescripcion().value());
        Assertions.assertEquals("[111]", command.getImplementos().keySet().toString());
       // for (Map.Entry<ImplementoId,Implemento> entry: datos.entrySet())
         //   Map<ImplementoId, Implemento> categorias


    }
}