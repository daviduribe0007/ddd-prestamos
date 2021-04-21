package co.com.softka.softkau.ddd.domain.inventario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CodigoBarras implements ValueObject<String> {
    private final String value;

    public CodigoBarras(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}