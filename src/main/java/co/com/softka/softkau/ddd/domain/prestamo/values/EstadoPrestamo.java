package co.com.softka.softkau.ddd.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoPrestamo implements ValueObject<Boolean> {
    private  final Boolean value;

    public EstadoPrestamo(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }

}
