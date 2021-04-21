package co.com.softka.softkau.ddd.domain.solicitante.events;

import co.com.sofka.domain.generic.ValueObject;

public class Estado  implements ValueObject<Boolean> {
    private  final Boolean value;

    public Estado(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return null;
    }
}
