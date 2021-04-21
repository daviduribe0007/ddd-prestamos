package co.com.softka.softkau.ddd.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

public class FechaSancion implements ValueObject<String> {
    private final String value;

    public FechaSancion(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return null;
    }
}
