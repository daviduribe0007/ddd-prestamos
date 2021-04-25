package co.com.softka.softkau.ddd.domain.inventario;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.inventario.events.CategoriaCreada;

public class CategoriaChange extends EventChange {
    public CategoriaChange(Categoria categoria) {

        apply((CategoriaCreada event) -> {
            categoria.implementos = event.categorias();
            categoria.descripcion = event.descripcion();
        });

    }
}
