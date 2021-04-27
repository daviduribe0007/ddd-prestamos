package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.Implemento;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.categoria.values.Descripcion;
import co.com.softka.softkau.ddd.domain.categoria.values.TiempoPrestamo;

import java.util.Map;

public class CategoriaCreada extends DomainEvent {

    private final Descripcion descripcion;

    public CategoriaCreada( Descripcion descripcion) {
        super("ddd.categoria.creado");;
        this.descripcion = descripcion;
    }


    public Descripcion descripcion() {
        return descripcion;
    }

}
