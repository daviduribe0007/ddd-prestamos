package co.com.softka.softkau.ddd.domain.inventario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Calendar;
import java.util.Objects;

public class TiempoPrestamo implements ValueObject<Calendar> {
    private final Calendar value;

    public TiempoPrestamo(Calendar value) {
        this.value = Objects.requireNonNull(value);
        if (0 <= this.value.getTime().compareTo(Calendar.getInstance().getTime())) {
            throw new IllegalArgumentException("El valor de la fecha de prestamo no puede ser anterior a la fecha presente");
        }
    }

    @Override
    public Calendar value() {
        return value;
    }
}
