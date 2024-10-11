package com.e_commerce.demo.dao;

import com.e_commerce.demo.model.Producto;

import java.util.List;

public interface ProductoDAO {
    void agregarProducto(Producto producto);
    void actualizarProducto(int id, Producto producto);
    void eliminarProducto(int id);
    Producto obtenerProducto(int id);
    List<Producto> listarProductos();
}
