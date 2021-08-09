
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity(name="huespedes")
public class Huesped extends Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_huesped")
    private long idHuesped;
    
    @Column (name = "prof_huesped")
    private String profesion;
    
    @OneToOne(mappedBy = "huesped", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Reserva reserva;


    public Huesped() {
    }

    public Huesped(long idHuesped, String profesion) {
        this.idHuesped = idHuesped;
        this.profesion = profesion;
    }

    public Huesped(long idHuesped, String profesion, String dni, String nombre, String apellido, Date fecha_nac, String direccion) {
        super(dni, nombre, apellido, fecha_nac, direccion);
        this.idHuesped = idHuesped;
        this.profesion = profesion;
    }

    public Huesped(long idHuesped, String profesion, Reserva reserva) {
        this.idHuesped = idHuesped;
        this.profesion = profesion;
        this.reserva = reserva;
    }

    public Huesped(long idHuesped, String profesion, Reserva reserva, String dni, String nombre, String apellido, Date fecha_nac, String direccion) {
        super(dni, nombre, apellido, fecha_nac, direccion);
        this.idHuesped = idHuesped;
        this.profesion = profesion;
        this.reserva = reserva;
    }
    

    public long getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(long idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    
    

    
    
    
}
