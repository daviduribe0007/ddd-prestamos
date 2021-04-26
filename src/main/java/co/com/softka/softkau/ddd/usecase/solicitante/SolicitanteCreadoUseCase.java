package co.com.softka.softkau.ddd.usecase.solicitante;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.softkau.ddd.domain.solicitante.Solicitante;
import co.com.softka.softkau.ddd.domain.solicitante.commands.CrearSolicitante;
import co.com.softka.softkau.ddd.domain.solicitante.events.SolicitanteCreado;
import co.com.softka.softkau.ddd.domain.solicitante.values.*;

import java.util.Calendar;
import java.util.Date;

public class SolicitanteCreadoUseCase extends UseCase<RequestCommand<CrearSolicitante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSolicitante> input) {


    var command= input.getCommand();
    var  solicitante = new Solicitante(command.getEntityId(),command.getNombre(),
            command.getEstado(),command.getPrioridad(),command.getFechaSancion());

        if (0 >= command.getFechaSancion().value().compareTo(Calendar.getInstance())) {
            throw new BusinessException(command.getEntityId().value(),
                    "El valor de la fecha de sancion no puede ser posterior a la fecha presente");
        }
    emit().onResponse(new ResponseEvents(solicitante.getUncommittedChanges()));

    }
}
