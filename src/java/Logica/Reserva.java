
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="reservas")
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reserva")
    private long id_reserva;
    
    @Temporal(TemporalType.DATE)
    @Column(name="check_in")
    private Date checkin;
    @Temporal(TemporalType.DATE)
    @Column(name="check_out")
    private Date checkout;
    
    @Column(name="cant_personas")
    private int cantidadPerso;
    
    @Column(name="totalEstadia")
    private int total;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dia_realizada")
    private Date diaRealizacion;
    
    @OneToOne
    @JoinColumn(name="id_empleado")
    private Empleado empleado;
    
    
    @OneToOne
    @JoinColumn(name="id_huesped")
    private Huesped huesped;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    public Reserva() {
    }

    public Reserva(long id_reserva, Date checkin, Date checkout, int cantidadPerso, int total, Date diaRealizacion, Empleado empleado, Huesped huesped, Habitacion habitacion) {
        this.id_reserva = id_reserva;
        this.checkin = checkin;
        this.checkout = checkout;
        this.cantidadPerso = cantidadPerso;
        this.total = total;
        this.diaRealizacion = diaRealizacion;
        this.empleado = empleado;
        this.huesped = huesped;
        this.habitacion = habitacion;
    }

    

    

    public int getCantidadPerso() {
        return cantidadPerso;
    }

    public void setCantidadPerso(int cantidadPerso) {
        this.cantidadPerso = cantidadPerso;
    }



    
    

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDiaRealizacion() {
        return diaRealizacion;
    }

    public void setDiaRealizacion(Date diaRealizacion) {
        this.diaRealizacion = diaRealizacion;
    }

    
    
    
    
}
