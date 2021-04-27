package co.com.softka.softkau.ddd.domain.categoria.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.ddd.domain.categoria.Implemento;
import co.com.softka.softkau.ddd.domain.categoria.values.CategoriaId;
import co.com.softka.softkau.ddd.domain.categoria.values.Descripcion;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;

import java.util.Map;

public class CrearCategoria implements Command {

    private final CategoriaId entityId;
    private final Descripcion descripcion;

    public CrearCategoria(CategoriaId entityId, Descripcion descripcion){

        this.entityId = entityId;
        this.descripcion = descripcion;
    }

    public CategoriaId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
