package entity;
// Generated 26/11/2019 01:16:58 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private String idproducto;
     private String nombre;
     private String marca;
     private String descripcion;
     private BigDecimal precio;
     private int existencia;
     private Set detalles = new HashSet(0);

    public Producto() {
    }

	
    public Producto(String idproducto, String nombre, String marca, String descripcion, BigDecimal precio, int existencia) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
    }
    public Producto(String idproducto, String nombre, String marca, String descripcion, BigDecimal precio, int existencia, Set detalles) {
       this.idproducto = idproducto;
       this.nombre = nombre;
       this.marca = marca;
       this.descripcion = descripcion;
       this.precio = precio;
       this.existencia = existencia;
       this.detalles = detalles;
    }
   
    public String getIdproducto() {
        return this.idproducto;
    }
    
    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public int getExistencia() {
        return this.existencia;
    }
    
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    public Set getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(Set detalles) {
        this.detalles = detalles;
    }




}


