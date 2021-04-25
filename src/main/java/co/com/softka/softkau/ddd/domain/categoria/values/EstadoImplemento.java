package co.com.softka.softkau.ddd.domain.categoria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoImplemento implements ValueObject<String> {
    private final String value;

    public EstadoImplemento(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}