package co.com.softka.softkau.ddd.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

public class Prioridad implements ValueObject<Integer> {
    private final Integer value;

    public Prioridad(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return null;
    }
}
