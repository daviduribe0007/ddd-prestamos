package co.com.softka.softkau.ddd.domain.categoria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Calendar;
import java.util.Objects;

public class TiempoPrestamo implements ValueObject<Integer> {
    private final Integer value;

    public TiempoPrestamo(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
