package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.softka.softkau.ddd.domain.categoria.values.*;

public class ImplementoCreado extends co.com.sofka.domain.generic.DomainEvent {
    private final ImplementoId implementoId;
    private final Tipo tipo;
    private final Descripcion descripcionImplemento;
    private final CodigoBarras codigoBarras;
    private final EstadoImplemento estadoImplemento;
    private final Extraible extraible;
    private final Prestamo prestamo;

    public ImplementoCreado(ImplementoId implementoId, Tipo tipo, Descripcion descripcionImplemento,
                            CodigoBarras codigoBarras, EstadoImplemento estadoImplemento,
                            Extraible extraible, Prestamo prestamo) {
        super("ddd.categoria.implementocreado");
        this.implementoId = implementoId;
        this.tipo = tipo;
        this.descripcionImplemento = descripcionImplemento;
        this.codigoBarras = codigoBarras;
        this.estadoImplemento = estadoImplemento;
        this.extraible = extraible;
        this.prestamo = prestamo;
    }

    public ImplementoId implementoId() {
        return implementoId;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Descripcion descripcionImplemento() {
        return descripcionImplemento;
    }

    public CodigoBarras codigoBarras() {
        return codigoBarras;
    }

    public EstadoImplemento estadoImplemento() {
        return estadoImplemento;
    }

    public Extraible extraible() {
        return extraible;
    }

    public Prestamo prestamo() {
        return prestamo;
    }
}
