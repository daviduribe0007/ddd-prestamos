package co.com.softka.softkau.ddd.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class PrestamoId extends Identity {


    public PrestamoId(Integer uuid) {
        super(uuid.toString());
    }

    public PrestamoId() {
    }

    public static PrestamoId of(Integer uuid) {
        return new PrestamoId(uuid);
    }
}
