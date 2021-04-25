package co.com.softka.softkau.ddd.domain.inventario;

import co.com.sofka.domain.generic.EventChange;
import co.com.softka.softkau.ddd.domain.inventario.events.InventarioCreado;
import co.com.softka.softkau.ddd.domain.prestamo.Prestamo;
import co.com.softka.softkau.ddd.domain.prestamo.events.PrestamoSolicitado;

public class InventarioChange extends EventChange {
    public InventarioChange(Inventario inventario) {

        apply((InventarioCreado event) -> {
            inventario.categorias = event.categorias();
            inventario.descripcion = event.descripcion();
        });

    }
}
