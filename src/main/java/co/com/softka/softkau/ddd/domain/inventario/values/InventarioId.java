package co.com.softka.softkau.ddd.domain.inventario.values;

import co.com.sofka.domain.generic.Identity;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

public class InventarioId extends Identity {

    public InventarioId(String uuid) {
        super(uuid);
    }

    public InventarioId() {
    }

    public static InventarioId of(String uuid) {
        return new InventarioId(uuid);
    }

}