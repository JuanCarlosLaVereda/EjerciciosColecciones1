package es.ieslavereda.Ejercicio1;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pais españa = new Pais("España", 47000000);
        Pais portugal= new Pais("Portugal", 35000000);
        Pais francia = new Pais("Francia", 50000000);
        Pais alemania = new Pais("Alemania", 55000000);
        Pais marruecos = new Pais("Marruecos", 33000000);


        Map<Trabajador, Pais> trabajadores = new TreeMap<>();

        trabajadores.put(new Trabajador("12345678X", "Pepe", "Rodriguez", LocalDate.of(1986, 11, 22)), españa);
        trabajadores.put(new Trabajador("12345678X", "Pepe", "Rodriguez", LocalDate.of(1963, 11, 22)), españa);
        trabajadores.put(new Trabajador("12345678X", "Pepe", "88", LocalDate.of(1990, 11, 22)), alemania);
        trabajadores.put(new Trabajador("12345677X", "Pepe", "Rodriguez", LocalDate.of(1986, 11, 22)), marruecos);
        trabajadores.put(new Trabajador("12345678X", "Pepito", "Rodriguez", LocalDate.of(2000, 11, 22)), marruecos);
        trabajadores.put(new Trabajador("123456767X", "Pepe", "Quien?", LocalDate.of(1923, 11, 22)), portugal);
        trabajadores.put(new Trabajador("12345678X", "Pepe", "Apensab", LocalDate.of(1956, 11, 22)), francia);
        trabajadores.put(new Trabajador("12345673X", "El bicho", "Ay mi madre", LocalDate.of(1976, 11, 22)), portugal);
        trabajadores.put(new Trabajador("12345678X", "Pepito", "El chocolatero", LocalDate.of(1933, 11, 22)), españa);

        System.out.println(trabajadores.keySet());

        Set<Pais> trabajadoresPaises = new TreeSet<>(trabajadores.values());
        System.out.println(trabajadoresPaises);
        Set<Trabajador> trabajadoresSet = new TreeSet<>(trabajadores.keySet());
        System.out.println(trabajadoresSet);
        List<Trabajador> trabajadorList = new ArrayList<>(trabajadores.keySet());
        Collections.sort(trabajadorList);
        System.out.println(trabajadorList);

        Iterator<Trabajador> iterator = trabajadoresSet.iterator();

        System.out.println("Trabajadores con mas de 50 años: ");

        while (iterator.hasNext()){
            Trabajador trabajadorAux = iterator.next();
            if (trabajadorAux.getEdad()>50){
                System.out.println(trabajadorAux);
            }
        }



    }
}
