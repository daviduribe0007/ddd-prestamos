package co.com.softka.softkau.ddd.usecase.categoria;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.softkau.ddd.domain.categoria.Categoria;
import co.com.softka.softkau.ddd.domain.categoria.commands.CrearImplemento;

public class CrearImplementoUseCase extends UseCase<RequestCommand<CrearImplemento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearImplemento> input) {
        var command= input.getCommand();
        var categoria = Categoria.from(command.getCategoriaId(),retrieveEvents());

        try{
            categoria.implementoCreado(command.getImplementoId(),
                    command.getTipo(),command.getDescripcionImplemento(),command.getCodigoBarras(),
                    command.getEstadoImplemento(),command.getExtraible(),command.getPrestamo());
            emit().onResponse((new ResponseEvents(categoria.getUncommittedChanges())));
        }catch(RuntimeException e){
            emit().onError(new BusinessException(categoria.identity().value(), e.getMessage()));
        }
    }
}
