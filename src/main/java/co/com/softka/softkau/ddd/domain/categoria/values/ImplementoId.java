package co.com.softka.softkau.ddd.domain.categoria.values;

import co.com.sofka.domain.generic.Identity;

public class ImplementoId extends Identity {

    public ImplementoId(String uuid) {
        super(uuid);
    }

    public ImplementoId() {
    }

    public static ImplementoId of(String uuid) {
        return new ImplementoId(uuid);
    }

}