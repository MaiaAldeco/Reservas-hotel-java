
package Logica;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "habitaciones")
public class Habitacion implements Serializable {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_habitacion")
    long id_habitacion;
    

    @Column (name = "piso_habitacion")
    int piso_habitacion;
    
    @Column (name = "tematica_habi")
    String tematica;
    
    @Column (name = "tipo_habitacion")
    String tipoHabitacion;
    
    @Column (name = "precio_noche")
    int precio;
    
    @OneToMany(mappedBy="habitacion",cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Reserva>listaReserva;
    
    
    public Habitacion() {
    }

    public Habitacion(long id_habitacion, int piso_habitacion, String tematica, String tipoHabitacion, int precio, List<Reserva> listaReserva) {
        this.id_habitacion = id_habitacion;
        this.piso_habitacion = piso_habitacion;
        this.tematica = tematica;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.listaReserva = listaReserva;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    public long getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(long id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getPiso_habitacion() {
        return piso_habitacion;
    }

    public void setPiso_habitacion(int piso_habitacion) {
        this.piso_habitacion = piso_habitacion;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }
    
    
    
    
    
}
