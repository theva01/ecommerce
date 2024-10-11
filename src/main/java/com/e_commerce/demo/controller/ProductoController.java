package com.e_commerce.demo.controller;
import com.e_commerce.demo.config.Configuracion;
import com.e_commerce.demo.dao.ProductoDAO;
import com.e_commerce.demo.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private ProductoDAO productoDAO;

    public ProductoController() {
        // Simular la selección de la base de datos (puedes cambiar a "Oracle" para probar)
        productoDAO = Configuracion.configureAdapterDB("MySQL");
    }

    @GetMapping
    public List<Producto> listarProductos() {
        List<Producto> productos = productoDAO.listarProductos();
        return productos;
    }

    @GetMapping("PrimerProducto")
    public Producto listarPrimerProducto() {
        List<Producto> productos = productoDAO.listarProductos();
        return productos.get(0);
    }

    @PostMapping
    public void agregarProducto(@RequestBody Producto producto) {
        productoDAO.agregarProducto(producto);
    }

    @PutMapping("{id}")
    public void actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
        productoDAO.actualizarProducto(id, producto);
    }

    @DeleteMapping("{id}")
    public void eliminarProducto(@PathVariable int id) {
        productoDAO.eliminarProducto(id);
    }

    @GetMapping("{id}")
    public Producto obtenerProducto(@PathVariable int id) {
        return productoDAO.obtenerProducto(id);
    }
}
