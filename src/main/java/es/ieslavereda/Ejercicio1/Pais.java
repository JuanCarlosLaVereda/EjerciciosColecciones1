package es.ieslavereda.Ejercicio1;

public class Pais implements Comparable<Pais>{
    private String nombre;
    private Integer poblacion;

    public Pais(String nombre, Integer poblacion){
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }
    public Integer getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public int hashCode(){
        return nombre.hashCode()+poblacion;
    }

    @Override
    public int compareTo(Pais pais){
        return nombre.compareTo(pais.getNombre());
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Pais)){
            return false;
        }
        Pais pais = (Pais) obj;
        return nombre.equals(pais.getNombre());
    }


    @Override
    public String toString(){
        return "\nNombre del pais: " + nombre +
                "\nNº de poblacion: " + poblacion;
    }
}
