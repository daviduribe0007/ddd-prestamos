package co.com.softka.softkau.ddd.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Calendar;

public class FechaSancion implements ValueObject<Calendar> {
    private final Calendar value;

    public FechaSancion(Calendar value) {
        this.value = value;

    }

    @Override
    public Calendar value() {
        return value;
    }
}
