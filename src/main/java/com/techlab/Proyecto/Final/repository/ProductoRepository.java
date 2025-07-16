package com.techlab.Proyecto.Final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.Proyecto.Final.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
  

List<Producto> findByNombreContainingIgnoreCase(String nombre);



}
