package co.com.softka.softkau.ddd.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

public class Entregado implements ValueObject<Boolean> {
    private  final Boolean value;

    public Entregado(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }

}