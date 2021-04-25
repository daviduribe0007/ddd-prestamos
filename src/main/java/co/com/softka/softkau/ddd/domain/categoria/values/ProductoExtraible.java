package co.com.softka.softkau.ddd.domain.categoria.values;

import co.com.sofka.domain.generic.ValueObject;

public class ProductoExtraible implements ValueObject<Boolean> {
    private  final Boolean value;

    public ProductoExtraible(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }
}
