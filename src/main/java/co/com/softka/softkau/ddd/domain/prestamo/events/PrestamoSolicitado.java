package co.com.softka.softkau.ddd.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.softka.softkau.ddd.domain.categoria.Categoria;
import co.com.softka.softkau.ddd.domain.categoria.values.CategoriaId;
import co.com.softka.softkau.ddd.domain.prestamo.values.Entregado;
import co.com.softka.softkau.ddd.domain.prestamo.values.EstadoPrestamo;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaRetorno;
import co.com.softka.softkau.ddd.domain.prestamo.values.FechaPrestamo;
import co.com.softka.softkau.ddd.domain.solicitante.values.SolicitanteId;

import java.util.Map;

public class PrestamoSolicitado extends DomainEvent {

    private final Map<CategoriaId, Categoria> inventarioMap;
    private final SolicitanteId solicitanteId;
    private final EstadoPrestamo estadoPrestamo;
    private final Entregado entregado;
    private final FechaPrestamo fechaPrestamo;
    private final FechaRetorno fechaRetorno;


    public PrestamoSolicitado(Map<CategoriaId, Categoria> inventarioId, SolicitanteId solicitanteId,
                              EstadoPrestamo estadoPrestamo, Entregado entregado,
                              FechaPrestamo fechaPrestamo, FechaRetorno fechaRetorno) {
        super("ddd.prestamo.solicitado");
        this.inventarioMap = inventarioId;
        this.solicitanteId = solicitanteId;
        this.estadoPrestamo = estadoPrestamo;
        this.entregado = entregado;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRetorno = fechaRetorno;
    }

    public Map<CategoriaId, Categoria> inventarioMap() {
        return inventarioMap;
    }

    public Entregado entregado() {
        return entregado;
    }

    public SolicitanteId solicitanteId() {
        return solicitanteId;
    }

    public EstadoPrestamo estadoPrestamo() {
        return estadoPrestamo;
    }

    public FechaPrestamo fechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaRetorno fechaRetorno() {
        return fechaRetorno;
    }
}
