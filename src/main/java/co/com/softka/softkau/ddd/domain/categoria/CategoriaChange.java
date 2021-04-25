package co.com.softka.softkau.ddd.domain.categoria;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.categoria.events.CategoriaCreada;
import co.com.softka.softkau.ddd.domain.categoria.events.ImplementoPrestado;
import co.com.softka.softkau.ddd.domain.categoria.events.ImplementoSolicitado;

public class CategoriaChange extends EventChange {
    public CategoriaChange(Categoria categoria) {

        apply((CategoriaCreada event) -> {
            categoria.implementos = event.categorias();
            categoria.descripcion = event.descripcion();
        });

        apply((ImplementoSolicitado event) -> {
            categoria.implementos.get(event.implementoId())
                    .cambiarEstadoPrestamo(event.prestamo());
        });

        apply((ImplementoPrestado event) -> {
            categoria.implementos.get(event.implementoId())
                    .cambiarEstadoPrestamo(event.prestamo());
            categoria.implementos.get(event.implementoId())
                    .cambiarFechaRetorno(event.fechaRetorno());
        });





    }
}
