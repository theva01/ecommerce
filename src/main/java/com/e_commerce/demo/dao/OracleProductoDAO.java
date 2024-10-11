package com.e_commerce.demo.dao;
import com.e_commerce.demo.model.Producto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OracleProductoDAO implements ProductoDAO {
    private Map<Integer, Producto> productos;

    public OracleProductoDAO() {
        productos = new HashMap<>();

        productos.put(1, new Producto(1, "Laptop", 1500.00));
        productos.put(2, new Producto(2, "Smartphone", 800.00));
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public void actualizarProducto(int id, Producto producto) {
        productos.put(id, producto);
    }

    @Override
    public void eliminarProducto(int id) {
        productos.remove(id);
    }

    @Override
    public Producto obtenerProducto(int id) {
        return productos.get(id);
    }

    @Override
    public List<Producto> listarProductos() {
        return productos.values().stream().collect(Collectors.toList());
    }
}
