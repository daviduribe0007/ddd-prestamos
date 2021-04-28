package co.com.softka.softkau.ddd.domain.categoria;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.categoria.events.*;

import java.util.HashMap;

public class CategoriaChange extends EventChange {
    public CategoriaChange(Categoria categoria) {

        apply((CategoriaCreada event) -> {
            categoria.descripcion = event.descripcion();
            categoria.implementos = new HashMap<>();
        });

        apply((ImplementoCreado event)->{
           categoria.implementos.put(event.implementoId(),
                   new Implemento(event.implementoId(),
                           event.tipo(),
                           event.descripcionImplemento(),
                           event.codigoBarras(),
                           event.estadoImplemento(),
                           event.extraible(),
                           event.prestamo()));
        });

        apply((ImplementoSolicitado event) -> {
            categoria.implementos.get(event.implementoId())
                    .cambiarEstadoPrestamo(event.prestamo());
        });

        apply((ImplementoPrestado event) -> {
            categoria.implementos.get(event.implementoId())
                    .cambiarEstadoPrestamo(event.prestamo());
            categoria.implementos.get(event.implementoId())
                    .cambiarFechaTiempoPrestamo(event.fechaTiempoPrestamo());
        });

        apply((ImplementoRetornado event) -> {
            categoria.implementos.get(event.implementoId())
                    .cambiarEstadoPrestamo(event.prestamo());
            categoria.implementos.get(event.implementoId())
                    .cambiarFechaRetorno(event.fechaRetorno());
            categoria.implementos.get(event.implementoId())
                    .cambiarEstadoImplemento(event.estadoImplemento());
        });





    }
}
