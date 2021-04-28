package co.com.softka.softkau.ddd.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class PrestamoId extends Identity {


    public PrestamoId(String uuid) {
        super(uuid);
    }

    public PrestamoId() {
    }

    public static PrestamoId of(String uuid) {
        return new PrestamoId(uuid);
    }
}
