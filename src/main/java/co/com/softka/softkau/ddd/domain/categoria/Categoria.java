package co.com.softka.softkau.ddd.domain.categoria;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.events.*;
import co.com.softka.softkau.ddd.domain.categoria.values.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Categoria extends AggregateEvent<CategoriaId> {


    protected Map<ImplementoId, Implemento> implementos;
    protected Descripcion descripcion;

    public Categoria(CategoriaId entityId, Descripcion descripcion) {
        super(entityId);
        appendChange(new CategoriaCreada(entityId,descripcion)).apply();
    }


    private Categoria(CategoriaId entityId) {
        super(entityId);
        subscribe(new CategoriaChange(this));
    }

    public static Categoria from(CategoriaId entityId, List<DomainEvent> events) {
        var categoria = new Categoria(entityId);
        events.forEach(categoria::applyEvent);
        return categoria;
    }

    public void implementoCreado(ImplementoId implementoId, Tipo tipo, Descripcion descripcion,
                                 CodigoBarras codigoBarras, EstadoImplemento estadoImplemento,
                                 Extraible extraible, Prestamo prestamo) {

        appendChange(new ImplementoCreado(implementoId, tipo, descripcion, codigoBarras, estadoImplemento,
                extraible, prestamo)).apply();
    }


    public void SolicitarImplemento(ImplementoId implementoId, boolean prestamo) {
        appendChange(new ImplementoSolicitado(implementoId, prestamo)).apply();

    }

    public void prestarImplemento(ImplementoId implementoId, boolean prestamo, Calendar fechaTiempoPrestamo) {
        appendChange(new ImplementoPrestado(implementoId, prestamo, fechaTiempoPrestamo)).apply();
    }


    public void retornarImplemento(ImplementoId implementoId, String estadoImplemento, boolean prestamo, Calendar fechaRetorno) {
        appendChange(new ImplementoRetornado(implementoId, estadoImplemento, prestamo, fechaRetorno)).apply();
    }


}
