package co.com.softka.softkau.ddd.domain.inventario.values;

import co.com.sofka.domain.generic.Identity;

public class CategoriaId extends Identity {

    public CategoriaId(String uuid) {
        super(uuid);
    }

    public CategoriaId() {
    }

    public static CategoriaId of(String uuid) {
        return new CategoriaId(uuid);
    }

}