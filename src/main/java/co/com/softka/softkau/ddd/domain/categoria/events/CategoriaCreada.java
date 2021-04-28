package co.com.softka.softkau.ddd.domain.categoria.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.values.CategoriaId;
import co.com.softka.softkau.ddd.domain.categoria.values.Descripcion;

public class CategoriaCreada extends DomainEvent {

    private final Descripcion descripcion;
    private final CategoriaId entityId;

    public CategoriaCreada(CategoriaId entityId, Descripcion descripcion) {
        super("ddd.categoria.creado");
        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public CategoriaId getEntityId() {
        return entityId;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

}
