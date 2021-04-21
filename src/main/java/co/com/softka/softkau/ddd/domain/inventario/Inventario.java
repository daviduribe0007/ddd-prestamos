package co.com.softka.softkau.ddd.domain.inventario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.softka.softkau.ddd.domain.inventario.values.CategoriaId;
import co.com.softka.softkau.ddd.domain.inventario.values.Descripcion;
import co.com.softka.softkau.ddd.domain.inventario.values.InventarioId;

import java.util.Map;

public class Inventario extends AggregateEvent<InventarioId> {

    protected Map<CategoriaId, Categoria> categorias;
    private final Descripcion descripcion;

    public Inventario(InventarioId entityId, Map<CategoriaId, Categoria> categorias, Descripcion descripcion) {
        super(entityId);
        this.categorias = categorias;
        this.descripcion = descripcion;
    }
}
