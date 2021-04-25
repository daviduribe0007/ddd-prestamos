package co.com.softka.softkau.ddd.domain.inventario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.inventario.events.CategoriaCreada;
import co.com.softka.softkau.ddd.domain.inventario.values.ImplementoId;
import co.com.softka.softkau.ddd.domain.inventario.values.Descripcion;
import co.com.softka.softkau.ddd.domain.inventario.values.CategoriaId;

import java.util.List;
import java.util.Map;

public class Categoria extends AggregateEvent<CategoriaId> {

    protected Map<ImplementoId, Implemento> implementos;
    protected  Descripcion descripcion;

    public Categoria(CategoriaId entityId, Map<ImplementoId, Implemento> implementos, Descripcion descripcion) {
        super(entityId);
        appendChange( new CategoriaCreada(implementos,descripcion)).apply();
    }



    private Categoria(CategoriaId entityId) {
        super(entityId);
        subscribe(new CategoriaChange(this));
    }

    public static Categoria from(CategoriaId entityId, List<DomainEvent> events) {
        var categoria= new Categoria(entityId);
        events.forEach(categoria::applyEvent);
        return categoria;
    }





}
