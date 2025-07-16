package com.techlab.Proyecto.Final.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.techlab.Proyecto.Final.entity.Producto;
import com.techlab.Proyecto.Final.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {

    ProductoService productoService;

    public Controllers(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String listarProducto(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "lista";
    }

    @GetMapping("/productos/nuevo")
    public String RegistroProducto(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "form";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String FormEditarProducto(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.obtenerProductoPorId(id));
        return "editar";
    }

    @PostMapping("/productos/nuevo/{id}")
    public String editarProducto(@PathVariable Long id, Producto producto) {
        productoService.editaProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }

    @PostMapping("/productos/buscarId")  
    public String buscarProductoPorId(@RequestParam Long id, Model model) { 
        Producto product = productoService.obtenerProductoPorId(id); 
        if (product != null) {       
            model.addAttribute("producto", product); 
            model.addAttribute("nombre", product.getNombre());
            model.addAttribute("precio", product.getPrecio());
            model.addAttribute("stock", product.getStock());
        } else {    
            model.addAttribute("error", "Producto no encontrado con ID: " + id);
        }
        return "buscarId";
    }

    @GetMapping("productos/buscarId")
    public String mostrarFormularioPorId() {      
        return "buscarId";
    }

    @GetMapping("/productos/buscar")
    public String formularioBuscarPorNombre(Model model) {
        return "buscar";
    }
    
    @PostMapping("/productos/buscarNombre")
    public String buscarProductoPorNombre(@RequestParam String nombre, Model model) {
        List<Producto> productos = productoService.buscarProductoPorNombre(nombre);
        if (productos.isEmpty()) {
            model.addAttribute("error", "No se encontraron productos con el nombre: " + nombre);
        } else {
            model.addAttribute("productos", productos);
        }
        return "buscar";
    }   



}
