package com.upc.authjwt20251.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "producto_local")
public class ProductoLocal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_producto_id", nullable = false)
    private CategoriaProducto categoriaProducto;

    @OneToMany(mappedBy = "productoLocal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Promocion> promociones;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private ProveedorServicio proveedor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public CategoriaProducto getCategoriaProducto() { return categoriaProducto; }
    public void setCategoriaProducto(CategoriaProducto categoriaProducto) { this.categoriaProducto = categoriaProducto; }

    public List<Promocion> getPromociones() { return promociones; }
    public void setPromociones(List<Promocion> promociones) { this.promociones = promociones; }

    public ProveedorServicio getProveedor() { return proveedor; }
    public void setProveedor(ProveedorServicio proveedor) { this.proveedor = proveedor; }
}