package co.com.softka.softkau.ddd.domain.inventario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Calendar;

public class FechaRetorno implements ValueObject<Calendar> {
    private final Calendar value;

    public FechaRetorno(Calendar value) {
        this.value = value;
        if (0 <= this.value.getTime().compareTo(Calendar.getInstance().getTime())) {
            throw new IllegalArgumentException("El valor de la fecha de retorno no puede ser anterior a la fecha presente");
        }
    }

    @Override
    public Calendar value() {
        return value;
    }
}