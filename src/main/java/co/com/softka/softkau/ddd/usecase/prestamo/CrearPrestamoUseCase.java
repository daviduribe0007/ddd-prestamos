package co.com.softka.softkau.ddd.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.softka.softkau.ddd.domain.prestamo.Prestamo;
import co.com.softka.softkau.ddd.domain.prestamo.commands.CrearPrestamo;

public class CrearPrestamoUseCase extends UseCase<RequestCommand<CrearPrestamo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPrestamo> input) {
        var command= input.getCommand();
        var prestamo= new Prestamo(command.getPrestamoId(),command.getImplementoId(),
                command.getSolicitanteId(),command.getEstadoPrestamo(),command.getEntregado(),
                command.getFechaPrestamo(),command.getFechaRetorno());
        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
