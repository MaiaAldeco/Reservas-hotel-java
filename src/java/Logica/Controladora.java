
package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    
    public boolean verificarUsuario(String usuario, String contrasenia){
        boolean autorizacion = false;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        
        if(listaUsuarios != null){
            for(Usuario usu : listaUsuarios ){
                if(usu.getUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)){
                    autorizacion = true;
                    return autorizacion;
                }
            }
        }
        return autorizacion;
    }
    public void crearHuesped(String dni, String nombre, String apellido, Date fecha1, String direccion, String profesion){
        Huesped huesped = new Huesped();
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setProfesion(profesion);
        huesped.setFecha_nac(fecha1);
        huesped.setDireccion(direccion);
      
        
        controlPersis.crearHuesped(huesped);
    }
    
    public void crearReserva(Empleado empleado, Huesped huesped, Date checkin, Date checkout, Habitacion habitacion, int cantPerso, int total, Date emision){
        Reserva reserva = new Reserva();
        reserva.setEmpleado(empleado);
        reserva.setHuesped(huesped);
        reserva.setCheckin(checkin);
        reserva.setCheckout(checkout);
        reserva.setHabitacion(habitacion);
        reserva.setCantidadPerso(cantPerso);
        reserva.setTotal(total);
        reserva.setDiaRealizacion(emision);
        controlPersis.crearReserva(reserva);
    }
    
    public void crearUsuario(String usuario, String contrasenia){
        Usuario usu = new Usuario();
        usu.setUsuario(usuario);
        usu.setContrasenia(contrasenia);
        
        controlPersis.crearUsuario(usu);
        
    }
    public Usuario buscarUsuario(long id_usuario){
        Usuario usu = controlPersis.buscarUsuario(id_usuario);
        return usu;
    }
    
    public void crearHabitacion(int piso_habitacion, String tematica, String tipoHabitacion,int precio){
        Habitacion habitacion = new Habitacion();
       // Reserva reserva = buscarReserva(Long.parseLong(id_reserva));
       // List<Reserva> listaReservas = traerReservas();
        //listaReservas.add(reserva);
        
        habitacion.setPiso_habitacion(piso_habitacion);
        habitacion.setTematica(tematica);
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setPrecio(precio);
       // habitacion.setListaReserva(listaReservas);
        
        controlPersis.crearHabitacion(habitacion);
        
        
    }
    public List reservaPorFecha(String fecha) {
      List<Reserva> listaReservas;
            
            listaReservas = controlPersis.traerReservas();
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            
            Date fechaConsulta = formato.parse(fecha);
            
            
            Iterator<Reserva> iterador = listaReservas.iterator();
            if (listaReservas != null) {
                while (iterador.hasNext()) {
                    
                    
                    try {
                        Reserva reserva = iterador.next();
                        
                        
                        String fechaReserva = formato.format(reserva.getDiaRealizacion());
                        Date fechaR = formato.parse(fechaReserva);
                        
                        if (fechaR.compareTo(fechaConsulta) != 0) {
                            iterador.remove();
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }

            }
          
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }return listaReservas;
            }

          

    public Reserva buscarFecha(Date checkin){
     //   Reserva reserva = buscarReserva(id);
        List <Reserva> listaReserva = traerReservas();
        for(Reserva reserva : listaReserva){
           reserva.getDiaRealizacion();
           if(checkin.equals(reserva.getDiaRealizacion())){
               return reserva;
           }
            
        }
        return null;
    }
    
    public void crearEmpleado(Usuario usu, String dni, String nombre, String apellido, Date fecha1, String direccion, String cargo){
        Empleado emple = new Empleado();
        emple.setDni(dni);
        emple.setNombre(nombre);
        emple.setApellido(apellido);        
        emple.setFecha_nac(fecha1);
        emple.setDireccion(direccion);
        emple.setCargo(cargo);
        emple.setUsuario(usu);

        
        controlPersis.crearEmpleado(emple);
    }
    
    public Empleado buscarEmpleado(long idEmpleado){
        Empleado emple = controlPersis.buscarEmpleado(idEmpleado);
        return emple;
    }
    
    public Huesped buscarHuesped(long idHuesped){
        Huesped huesped = controlPersis.buscarHuesped(idHuesped);
        return huesped;
    }
    
    public Reserva buscarReserva(long id_reserva){
        Reserva reserva = controlPersis.buscarReserva(id_reserva);
        return reserva;
    }
    public Habitacion buscarHabitacion(long id_habitacion){
        Habitacion habitacion = controlPersis.buscarHabitacion(id_habitacion);
        return habitacion;
    }
    
    
    public List<Empleado> traerEmpleados(){
        return controlPersis.traerEmpleados();
    }
    
    public List<Huesped> traerHuesped(){
        return controlPersis.traerHuesped();
    }
    public List<Usuario> traerUsuarios(){
        return (controlPersis.traerUsuarios());
    }
    public List<Habitacion> traerHabitacion(){
        return (controlPersis.traerHabitacion());
    }
    public List<Reserva> traerReservas(){
        return (controlPersis.traerReservas());
    }
   public void borrarHuesped(long idHuesped){
       controlPersis.borrarHuesped(idHuesped);
   }
   public void borrarEmpleado(long idEmpleado){
       controlPersis.borrarEmpleado(idEmpleado);
   }
   public void borrarUsuario(long id_usuario){
       controlPersis.borrarUsuario(id_usuario);
   }
   public void borrarHabitacion(long id_habitacion){
       controlPersis.borrarHabitacion(id_habitacion);
   }
   public void borrarReserva(long id_reserva){
       controlPersis.borrarReserva(id_reserva);
   }
   
   public void modificarHuesped(Huesped huesped){
       controlPersis.modificarHuesped(huesped);
   }
   public void modificarEmpleado(Empleado emple){
       controlPersis.modificarEmpleado(emple);
   }
   public void modificarReserva(Reserva reserva){
       controlPersis.modificarReserva(reserva);
   }
   public void modificarHabitacion(Habitacion habitacion){
       controlPersis.modificarHabitacion(habitacion);
   }
   public void modificarUsuario(Usuario usuario){
       controlPersis.modificarUsuario(usuario);
   }
   public int calcularTotal(int dias, int precio) {
       int total = precio;
       if(dias==0){
           return total;
           
       }else if(dias>0){
          
          total = precio * dias;
          return total;
       }
       return total;
    }
   public boolean verificarTipo(String tipo, int cantPersonas){
        boolean tipoHab = false;
   
            for(int i = 0; i<3; i++){
                
                if(tipo.equals("triple")&&cantPersonas<=3&&cantPersonas>=1){
                    System.out.println("La habitacion es : " + tipo + " cantidad personas: " + cantPersonas);
                    tipoHab = true;
                    return tipoHab;
                }
                if(tipo.equals("doble")&&cantPersonas>=1&&cantPersonas<=2){
                    System.out.println("La habitacion es : " + tipo + " cantidad personas: " + cantPersonas);
                    tipoHab = true;
                    return tipoHab;
                }
                if(tipo.equals("multiple")&&cantPersonas>=1&&cantPersonas<=5){
                    System.out.println("La habitacion es : " + tipo + " cantidad personas: " + cantPersonas);
                    tipoHab = true;
                    return tipoHab;
                }
                if(tipo.equals("single")&&cantPersonas==1){
                    System.out.println("La habitacion es : " + tipo + " cantidad personas: " + cantPersonas);
                    tipoHab = true;
                    return tipoHab;
                }
                
                }
             return tipoHab;
    }
   
   
   
   
   
   /*public boolean isWithinRange(long habitacion, LocalDate checkin, LocalDate checkout) {
       boolean estaOno = false;
    
      
      List<Reserva> listaReserva = controlPersis.traerReservas();
       for (Reserva reserva: listaReserva){
          
           Date checkIn = reserva.getCheckin();
           
           Date checkOut = reserva.getCheckout();
  
           LocalDate dateIN = checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           LocalDate dateOut = checkOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           
           if(reserva.getHabitacion().getId_habitacion()==habitacion){
               
           if(checkin.isAfter(dateIN)&&checkin.isBefore(dateOut)){
               System.out.println("bloque 1 " + checkin.isAfter(dateIN) + " " +checkin.isBefore(dateOut));
               estaOno = true;
               
               
           } else if(checkout.isAfter(dateIN)&&checkout.isBefore(dateOut)){
               System.out.println("bloque 2 " +checkout.isAfter(dateIN) + " " +  checkout.isBefore(dateOut));
               estaOno = true;
               
           }else if(checkin.equals(dateIN)&&checkout.isAfter(dateOut)){
               System.out.println("bloque 3 " +checkin.equals(dateIN)+ " " +checkout.isAfter(dateOut) );    
               estaOno = true; 
           } else if(checkout.equals(dateOut)&&checkin.isBefore(dateIN)){
               System.out.println("bloque 4 " + checkout.equals(dateOut) + " " + checkin.isAfter(dateIN));
               estaOno = true;
           }else if(checkin.isBefore(dateIN)&& checkout.isBefore(dateIN))
           return estaOno;
        }
   }
    System.out.println("La fecha esta en el sistema : "+ estaOno);    
  return estaOno;    
       
  }*/
   
   
 public boolean laFechaEsValidaOno(long habitacion,Date checkin, Date checkout){
     
     boolean estaOno = false;
    
      
      List<Reserva> listaReserva = controlPersis.traerReservas();
      for (Reserva reserva: listaReserva){
     if(reserva.getHabitacion().getId_habitacion()==habitacion){
       if (checkin.compareTo(reserva.getCheckin()) == 0){
           estaOno=true;
       }else if(checkout.compareTo(reserva.getCheckout()) == 0){
           estaOno=true;
       }
     
     }
     
     }
     return estaOno;
      }
     
 public List buscarReservaEmpleado(long idEmpleado) {
     
        List<Reserva> listaReservas;
        List <Reserva> listaReserva2 = new ArrayList();
        
        listaReservas = controlPersis.traerReservas();
        
        Iterator<Reserva> iterador = listaReservas.iterator();
        if (listaReservas != null) {
            while (iterador.hasNext()) {
                Reserva reserva = iterador.next();
                long infoId = reserva.getEmpleado().getIdEmpleado();

                if (idEmpleado != infoId) {
                    iterador.remove();
                } else{
                  listaReserva2.add(reserva);
            }
        }


    }
        return listaReserva2;
 }
     
  
 public List buscarPorHuesped(long idHuesped, String fechaDesde, String fechaHasta) {
             List<Reserva> listaReservas;
            
            List<Reserva> listaReservaHuesped = new ArrayList();
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
           
            
            Date desde = formato.parse(fechaDesde);
            Date hasta = formato.parse(fechaHasta);
            
            
            listaReservas = controlPersis.traerReservas();
            
            
            Iterator<Reserva> iterador = listaReservas.iterator();
            if (listaReservas != null) {
                while (iterador.hasNext()) {
                    Reserva reserva = iterador.next();
                    long idHuespedL = reserva.getHuesped().getIdHuesped();
                    
                    
                    if (idHuesped != idHuespedL) {
                        iterador.remove();
                    }
                }
            }
            
            
            Iterator<Reserva> iterador2 = listaReservas.iterator();
            
            while (iterador2.hasNext()){
                Reserva res = iterador2.next();
               
                Date fechaR = res.getCheckin();
                
                if(fechaR.after(desde) && fechaR.before(hasta) || fechaR.equals(desde) || fechaR.equals(hasta)){
                    listaReservaHuesped.add(res);
                } 
            }
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReservaHuesped;
    }
 
 
 
 
}
 

