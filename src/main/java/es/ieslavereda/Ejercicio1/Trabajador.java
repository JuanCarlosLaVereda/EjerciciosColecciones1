package es.ieslavereda.Ejercicio1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
//Falta iterar los que tengan mas de 50 años
//En el mapa ordenar por orden alfabetico (primero el apellido y luego el nombre)

public class Trabajador implements Comparable<Trabajador>{

    public static final Comparator<Trabajador> SORT_BY_AGE = new Comparator<Trabajador>() {
        @Override
        public int compare(Trabajador o1, Trabajador o2) {
            return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
        }
    };

    public static final Comparator<Trabajador> SORT_BY_AGE1 =
            (o1, o2) -> o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());

    public static final Comparator<Trabajador> SORT_BY_AGE2 =
            Comparator.comparing(Trabajador::getFechaNacimiento);


    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Trabajador(String dni, String nombre, String apellido, LocalDate fechaNacimiento){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Trabajador trabajador){
        if (apellido.equals(trabajador.getApellido())){
            return nombre.compareTo(trabajador.getNombre());
        }
        return apellido.compareTo(trabajador.getApellido());
    }

    @Override
    public int hashCode(){
        return dni.hashCode()+nombre.hashCode()+apellido.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Trabajador)){
            return false;
        }
        Trabajador trabajador = (Trabajador) obj;
        return (dni.equals(trabajador.getDni())) && nombre.equals(trabajador.getNombre()) && apellido.equals(trabajador.getApellido());
    }

    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getEdad() {
        return Period.between(fechaNacimiento,LocalDate.now()).getYears();
        //return LocalDate.now().getYear()-fechaNacimiento.getYear();
    }

    @Override
    public String toString(){
        return  "\n----------------------------------------" +
                "\nNombre y apellidos: " + apellido + " " + nombre +
                "\nDNI: " + dni +
                "\nFecha de nacimiento: " + fechaNacimiento + " (" + getEdad() + ")";
    }
}
