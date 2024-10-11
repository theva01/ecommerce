package com.e_commerce.demo.dao;

import com.e_commerce.demo.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class MySQLProductoDAO implements ProductoDAO {
    private List<Producto> productos;

    public MySQLProductoDAO() {
        productos = new ArrayList<>();
        // Datos por defecto
        productos.add(new Producto(1, "Laptop", 1500.00));
        productos.add(new Producto(2, "Smartphone", 800.00));
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void actualizarProducto(int id, Producto producto) {
        Producto p = obtenerProducto(id);
        if (p != null) {
            p.setDescripcion(producto.getDescripcion());
            p.setPrecio(producto.getPrecio());
        }
    }

    @Override
    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    @Override
    public Producto obtenerProducto(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> listarProductos() {
        return productos;
    }
}
