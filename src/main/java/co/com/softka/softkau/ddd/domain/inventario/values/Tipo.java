package co.com.softka.softkau.ddd.domain.inventario.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

import java.util.Objects;

public class Tipo implements ValueObject<String> {
    private final String value;

    public Tipo(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}