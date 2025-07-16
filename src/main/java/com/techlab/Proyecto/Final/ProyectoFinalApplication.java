package com.techlab.Proyecto.Final;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techlab.Proyecto.Final.entity.Producto;
import com.techlab.Proyecto.Final.service.ProductoService;

@SpringBootApplication
public class ProyectoFinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

	private final ProductoService productoService;

	public ProyectoFinalApplication(ProductoService productoService) {
		this.productoService = productoService;
	}

	@Override
	public void run(String... args) throws Exception {
		Producto producto1 = new Producto("Coca cola", 5500.0, 10);
		this.productoService.guardarProducto(producto1);
		Producto producto2 = new Producto("Pepsi", 5000.0, 15);
		productoService.guardarProducto(producto2);
		Producto producto3 = new Producto("Fanta", 6000.0, 20);
		productoService.guardarProducto(producto3);
		Producto producto4 = new Producto("Sprite", 5800.0, 12);
		productoService.guardarProducto(producto4);
		Producto producto5 = new Producto("Agua", 3000.0, 25);
		productoService.guardarProducto(producto5);
		Producto producto6 = new Producto("Red Bull", 12000.0, 8);
		productoService.guardarProducto(producto6);
		Producto producto7 = new Producto("Monster", 13000.0, 5);
		productoService.guardarProducto(producto7);

	}
}
