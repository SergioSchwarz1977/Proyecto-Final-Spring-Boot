package com.techlab.Proyecto.Final.service;

import java.util.List;

import com.techlab.Proyecto.Final.entity.Producto;

public interface ProductoServiceInterface {
   
    public List<Producto> listarProductos();
    public Producto guardarProducto(Producto producto);
    public Producto obtenerProductoPorId(Long id);
    public void eliminarProducto(Long id);
    public Producto editaProducto(Producto producto);
    public List<Producto> buscarProductoPorNombre(String nombre);


}
