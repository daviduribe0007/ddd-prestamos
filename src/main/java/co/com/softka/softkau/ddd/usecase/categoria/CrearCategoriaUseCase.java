package co.com.softka.softkau.ddd.usecase.categoria;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.softkau.ddd.domain.categoria.Categoria;
import co.com.softka.softkau.ddd.domain.categoria.commands.CrearCategoria;
import co.com.softka.softkau.ddd.domain.solicitante.Solicitante;

import java.util.Calendar;

public class CrearCategoriaUseCase extends UseCase<RequestCommand<CrearCategoria>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCategoria> input) {

        var command= input.getCommand();
        var  categoria = new Categoria(command.getEntityId(),
                command.getDescripcion());

        emit().onResponse(new ResponseEvents(categoria.getUncommittedChanges()));
    }
}
