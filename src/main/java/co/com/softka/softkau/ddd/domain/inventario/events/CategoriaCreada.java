package co.com.softka.softkau.ddd.domain.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.inventario.Implemento;
import co.com.softka.softkau.ddd.domain.inventario.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.inventario.values.Descripcion;

import java.util.Map;

public class CategoriaCreada extends DomainEvent {

    private final Map<ImplementoId, Implemento> categorias;
    private final Descripcion descripcion;

    public CategoriaCreada(Map<ImplementoId, Implemento> categorias, Descripcion descripcion) {
        super("ddd.inventario.creado");
        this.categorias = categorias;
        this.descripcion = descripcion;
    }

    public Map<ImplementoId, Implemento> categorias() {
        return categorias;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
