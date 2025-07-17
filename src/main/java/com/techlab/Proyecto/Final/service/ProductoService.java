package com.techlab.Proyecto.Final.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.techlab.Proyecto.Final.entity.Producto;
import com.techlab.Proyecto.Final.repository.ProductoRepository;

@Service
public class ProductoService implements ProductoServiceInterface {

    ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

   public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
  
    public Producto editaProducto(Producto producto) {       
        if (producto != null) {
            producto.setNombre(producto.getNombre());
            producto.setPrecio(producto.getPrecio());
            producto.setStock(producto.getStock());
            return productoRepository.save(producto);
        }
        return null;
    }

    public List<Producto> buscarProductoPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }



}
