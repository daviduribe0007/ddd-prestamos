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
        var categoriaId = CategoriaId.of("1234");
        var descripcion = new Descripcion("Video beam");

        var command = new CrearCategoria(categoriaId, descripcion);
        var useCase = new CategoriaCreadaUseCase();

        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        CategoriaCreada categoriaCreada = (CategoriaCreada) events.get(0);

        Assertions.assertTrue(Objects.nonNull(categoriaCreada.getClass()));
        Assertions.assertEquals("1234", categoriaCreada.aggregateRootId());
        Assertions.assertEquals("Video beam", categoriaCreada.descripcion().value());
    }
}
