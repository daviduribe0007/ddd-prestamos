package co.com.softka.softkau.ddd.domain.inventario;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.ddd.domain.inventario.values.*;

public class Implemento extends Entity<ImplementoId> {

    private final Tipo tipo;
    private final Descripcion descripcion;
    private final CodigoBarras codigoBarras;
    private final EstadoRecurso estadoRecurso;
    private final TiempoPrestamo tiempoPrestamo;
    private final FechaRetorno fechaRetorno;
    private final Extraible extraible;

    public Implemento(ImplementoId entityId, Tipo tipo, Descripcion descripcion, CodigoBarras codigoBarras,
                      EstadoRecurso estadoRecurso, TiempoPrestamo tiempoPrestamo, FechaRetorno fechaRetorno,
                      Extraible extraible) {
        super(entityId);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.codigoBarras = codigoBarras;
        this.estadoRecurso = estadoRecurso;
        this.tiempoPrestamo = tiempoPrestamo;
        this.fechaRetorno = fechaRetorno;
        this.extraible = extraible;
    }


}
