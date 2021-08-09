
package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleJpa = new EmpleadoJpaController();
    HabitacionJpaController habiJpa = new HabitacionJpaController();
    HuespedJpaController huespedJpa = new HuespedJpaController();
    ReservaJpaController reservaJpa = new ReservaJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    
    
    
    public void crearHuesped(Huesped huesped){
        huespedJpa.create(huesped);
    }
    
    public void crearEmpleado(Empleado emple){
        empleJpa.create(emple);
    }
    
    public void crearReserva(Reserva reserva){
        reservaJpa.create(reserva);
    }
    
    public void crearUsuario(Usuario usu){
        usuJpa.create(usu);
    }
    
    public void crearHabitacion(Habitacion habitacion){
        
        habiJpa.create(habitacion);
       
        
        
    }

    
    public List<Usuario> traerUsuarios(){
        return usuJpa.findUsuarioEntities();
    }
    public List<Reserva> traerReservas(){
        return reservaJpa.findReservaEntities();
    }
    public Usuario buscarUsuario(long id_usuario) {
        return (usuJpa.findUsuario(id_usuario));
    }
    
    public Empleado buscarEmpleado(long idEmpleado) {
        return (empleJpa.findEmpleado(idEmpleado));
    }
    public Habitacion buscarHabitacion(long id_habitacion) {
        return (habiJpa.findHabitacion(id_habitacion));
    }
    
    public Huesped buscarHuesped(long idHuesped) {
        return (huespedJpa.findHuesped(idHuesped));
    }
    
    public Reserva buscarReserva(long id_reserva){
        return (reservaJpa.findReserva(id_reserva));
    }
    
    public List<Empleado> traerEmpleados(){
        return empleJpa.findEmpleadoEntities();
    }
    
    public List<Huesped> traerHuesped(){
        return huespedJpa.findHuespedEntities();
    }
    public List<Habitacion> traerHabitacion(){
        return habiJpa.findHabitacionEntities();
    }
     
    public void borrarHuesped(long idHuesped){
        try {
            huespedJpa.destroy(idHuesped);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarEmpleado(long idEmpleado){
        
        try {
            empleJpa.destroy(idEmpleado);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarReserva(long id_reserva){
        try {
            reservaJpa.destroy(id_reserva);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarUsuario(long id_usuario){
        try {
            usuJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarHabitacion(long id_habitacion){
        try {
            habiJpa.destroy(id_habitacion);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarHuesped(Huesped huespued){
        try {
            huespedJpa.edit(huespued);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarUsuario(Usuario usuario){
        try {
            usuJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarEmpleado(Empleado emple){
        try {
            empleJpa.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarReserva(Reserva reserva){
        try {
            reservaJpa.edit(reserva);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarHabitacion(Habitacion habitacion){
        try {
            habiJpa.edit(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
}
