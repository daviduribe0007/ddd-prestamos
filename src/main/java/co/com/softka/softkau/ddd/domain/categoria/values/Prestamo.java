package co.com.softka.softkau.ddd.domain.categoria.values;

import co.com.sofka.domain.generic.ValueObject;

public class Prestamo implements ValueObject<Boolean> {
    private  final Boolean value;

    public Prestamo(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }
}