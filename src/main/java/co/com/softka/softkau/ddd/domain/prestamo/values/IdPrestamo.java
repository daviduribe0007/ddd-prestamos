package co.com.softka.softkau.ddd.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class IdPrestamo extends Identity {


    public IdPrestamo(Integer uuid) {
        super(uuid.toString());
    }

    public IdPrestamo() {
    }

    public static IdPrestamo of(Integer uuid) {
        return new IdPrestamo(uuid);
    }
}
