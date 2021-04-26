package co.com.softka.softkau.ddd.domain.categoria.commands;

import co.com.sofka.domain.generic.Command;
import co.com.softka.softkau.ddd.domain.categoria.Implemento;
import co.com.softka.softkau.ddd.domain.categoria.values.CategoriaId;
import co.com.softka.softkau.ddd.domain.categoria.values.Descripcion;
import co.com.softka.softkau.ddd.domain.categoria.values.ImplementoId;

import java.util.Map;

public class CrearCategoria implements Command {

    private final CategoriaId entityId;
    private final Map<ImplementoId, Implemento> implementos;
    private final Descripcion descripcion;

    public CrearCategoria(CategoriaId entityId, Map<ImplementoId, Implemento> implementos, Descripcion descripcion){

        this.entityId = entityId;
        this.implementos = implementos;
        this.descripcion = descripcion;
    }

    public CategoriaId getEntityId() {
        return entityId;
    }

    public Map<ImplementoId, Implemento> getImplementos() {
        return implementos;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
