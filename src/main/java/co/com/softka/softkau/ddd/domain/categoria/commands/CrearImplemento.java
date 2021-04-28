package co.com.softka.softkau.ddd.domain.categoria.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.ddd.domain.categoria.values.*;

public class CrearImplemento implements Command {

    private final CategoriaId categoriaId;
    private final ImplementoId implementoId;
    private final Tipo tipo;
    private final Descripcion descripcionImplemento;
    private final CodigoBarras codigoBarras;
    private final EstadoImplemento estadoImplemento;
    private final Extraible extraible;
    private final Prestamo prestamo;

    public CrearImplemento(CategoriaId categoriaId, ImplementoId implementoId, Tipo tipo, Descripcion descripcionImplemento,
                           CodigoBarras codigoBarras, EstadoImplemento estadoImplemento,
                           Extraible extraible, Prestamo prestamo){
        this.categoriaId = categoriaId;
        this.implementoId = implementoId;
        this.tipo = tipo;
        this.descripcionImplemento = descripcionImplemento;
        this.codigoBarras = codigoBarras;
        this.estadoImplemento = estadoImplemento;
        this.extraible = extraible;
        this.prestamo = prestamo;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Descripcion getDescripcionImplemento() {
        return descripcionImplemento;
    }

    public CodigoBarras getCodigoBarras() {
        return codigoBarras;
    }

    public EstadoImplemento getEstadoImplemento() {
        return estadoImplemento;
    }

    public Extraible getExtraible() {
        return extraible;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
}
