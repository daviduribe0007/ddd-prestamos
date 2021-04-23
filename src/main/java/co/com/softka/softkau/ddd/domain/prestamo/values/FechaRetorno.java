package co.com.softka.softkau.ddd.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Calendar;

public class FechaRetorno implements ValueObject<Calendar> {
    private final Calendar value;

    public FechaRetorno(Calendar value) {
        this.value = value;
    }

    @Override
    public Calendar value() {
        return value;
    }
}
