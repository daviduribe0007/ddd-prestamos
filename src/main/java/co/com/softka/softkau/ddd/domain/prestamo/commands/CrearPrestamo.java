package co.com.softka.softkau.ddd.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.prestamo.values.*;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

public class CrearPrestamo  implements Command {

    private final PrestamoId prestamoId;
    private final ImplementoId implementoId;
    private final SolicitanteId solicitanteId;
    private final EstadoPrestamo estadoPrestamo;
    private final Entregado entregado;
    private final FechaPrestamo fechaPrestamo;
    private final FechaRetorno fechaRetorno;

    public  CrearPrestamo(PrestamoId prestamoId, ImplementoId implementoId,
                          SolicitanteId solicitanteId, EstadoPrestamo estadoPrestamo, Entregado entregado,
                          FechaPrestamo fechaPrestamo, FechaRetorno fechaRetorno){
        this.prestamoId = prestamoId;

        this.implementoId = implementoId;
        this.solicitanteId = solicitanteId;
        this.estadoPrestamo = estadoPrestamo;
        this.entregado = entregado;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRetorno = fechaRetorno;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public SolicitanteId getSolicitanteId() {
        return solicitanteId;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public Entregado getEntregado() {
        return entregado;
    }

    public FechaPrestamo getFechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaRetorno getFechaRetorno() {
        return fechaRetorno;
    }
}
