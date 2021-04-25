package co.com.softka.softkau.ddd.domain.categoria;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.ddd.domain.categoria.values.*;

import java.util.Calendar;

public class Implemento extends Entity<ImplementoId> {

    private final Tipo tipo;
    private final Descripcion descripcion;
    private final CodigoBarras codigoBarras;
    private EstadoImplemento estadoImplemento;
    private  TiempoPrestamo tiempoPrestamo;
    private  FechaRetorno fechaRetorno;
    private final Extraible extraible;
    private Prestamo prestamo;

    public Implemento(ImplementoId entityId, Tipo tipo, Descripcion descripcion, CodigoBarras codigoBarras,
                      EstadoImplemento estadoImplemento, TiempoPrestamo tiempoPrestamo, TiempoPrestamo tiempoPrestamo1, FechaRetorno fechaRetorno,
                      Extraible extraible, Prestamo prestamo) {
        super(entityId);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.codigoBarras = codigoBarras;
        this.estadoImplemento = estadoImplemento;
        this.tiempoPrestamo = tiempoPrestamo1;
        this.fechaRetorno = fechaRetorno;
        this.extraible = extraible;
        this.prestamo = prestamo;
    }

    public void cambiarEstadoPrestamo(Boolean estado){
        this.prestamo = new Prestamo(estado);
    }
    public void cambiarEstadoImplemento(String estadoImplemento){
        this.estadoImplemento = new EstadoImplemento(estadoImplemento);
    }
    public void cambiarFechaTiempoPrestamo(Calendar fechaPrestamo){
        this.tiempoPrestamo = new TiempoPrestamo(fechaPrestamo);
    }
    public void cambiarFechaRetorno(Calendar fechaRetorno){
        this.fechaRetorno = new FechaRetorno(fechaRetorno);
    }
}
