package co.com.softka.softkau.ddd.domain.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.inventario.Categoria;
import co.com.softka.softkau.ddd.domain.inventario.values.CategoriaId;
import co.com.softka.softkau.ddd.domain.inventario.values.Descripcion;

import java.util.Map;

public class InventarioCreado extends DomainEvent {

    private final Map<CategoriaId, Categoria> categorias;
    private final Descripcion descripcion;

    public InventarioCreado(Map<CategoriaId, Categoria> categorias, Descripcion descripcion) {
        super("ddd.inventario.creado");
        this.categorias = categorias;
        this.descripcion = descripcion;
    }

    public Map<CategoriaId, Categoria> categorias() {
        return categorias;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
