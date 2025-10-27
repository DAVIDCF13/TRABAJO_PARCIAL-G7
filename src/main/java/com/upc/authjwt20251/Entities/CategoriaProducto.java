package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria_producto")
public class CategoriaProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "categoriaProducto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoLocal> productos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<ProductoLocal> getProductos() { return productos; }
    public void setProductos(List<ProductoLocal> productos) { this.productos = productos; }
}