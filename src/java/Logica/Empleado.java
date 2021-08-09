
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "empleados")
public class Empleado extends Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_empleado")
    private long idEmpleado;
    
    @Column(name="cargo_empleado")
    private String cargo;
    
    
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    
    @OneToOne(mappedBy = "empleado", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Reserva reserva;

    public Empleado() {
    }

    public Empleado(long idEmpleado, String cargo, Usuario usuario) {
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.usuario = usuario;
    }

    public Empleado(long idEmpleado, String cargo, Usuario usuario, String dni, String nombre, String apellido, Date fecha_nac, String direccion) {
        super(dni, nombre, apellido, fecha_nac, direccion);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.usuario = usuario;
    }

    public Empleado(long idEmpleado, String cargo, Usuario usuario, Reserva reserva) {
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.usuario = usuario;
        this.reserva = reserva;
    }

    public Empleado(long idEmpleado, String cargo, Usuario usuario, Reserva reserva, String dni, String nombre, String apellido, Date fecha_nac, String direccion) {
        super(dni, nombre, apellido, fecha_nac, direccion);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.usuario = usuario;
        this.reserva = reserva;
    }
    

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public Date getFecha_nac() {
        return fecha_nac;
    }

    @Override
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
