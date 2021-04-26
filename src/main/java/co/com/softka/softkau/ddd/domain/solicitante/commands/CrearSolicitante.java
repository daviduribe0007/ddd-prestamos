package co.com.softka.softkau.ddd.domain.solicitante.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.ddd.domain.solicitante.values.*;

public class CrearSolicitante  implements Command {

    private final SolicitanteId entityId;
    private final Nombre nombre;
    private final Estado estado;
    private final Prioridad prioridad;
    private final FechaSancion fechaSancion;

    public CrearSolicitante(SolicitanteId entityId, Nombre nombre, Estado estado
            , Prioridad prioridad, FechaSancion fechaSancion)
    {
        this.entityId = entityId;
        this.nombre = nombre;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaSancion = fechaSancion;
    }

    public SolicitanteId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public FechaSancion getFechaSancion() {
        return fechaSancion;
    }
}
