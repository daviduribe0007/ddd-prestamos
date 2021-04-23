package co.com.softka.softkau.ddd.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Calendar;

public class FechaSancion implements ValueObject<Calendar> {
    private final Calendar value;

    public FechaSancion(Calendar value) {
        this.value = value;
        if (0 <= this.value.getTime().compareTo(Calendar.getInstance().getTime())) {
            throw new IllegalArgumentException("El valor de la fecha de sancion no puede ser posterior a la fecha presente");
        }
    }

    @Override
    public Calendar value() {
        return null;
    }
}
