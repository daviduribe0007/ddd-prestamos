package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.Implemento;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.categoria.values.Descripcion;

import java.util.Map;

public class CategoriaCreada extends DomainEvent {

    private final Map<ImplementoId, Implemento> categorias;
    private final Descripcion descripcion;

    public CategoriaCreada(Map<ImplementoId, Implemento> categorias, Descripcion descripcion) {
        super("ddd.categoria.creado");
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
