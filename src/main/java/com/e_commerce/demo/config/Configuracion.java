package com.e_commerce.demo.config;
import com.e_commerce.demo.dao.MySQLProductoDAO;
import com.e_commerce.demo.dao.OracleProductoDAO;
import com.e_commerce.demo.dao.ProductoDAO;

public class Configuracion {
    public static ProductoDAO configureAdapterDB(String tipoDB) {
        if (tipoDB.equalsIgnoreCase("MySQL")) {
            return new MySQLProductoDAO();
        } else if (tipoDB.equalsIgnoreCase("Oracle")) {
            return new OracleProductoDAO();
        }
        throw new IllegalArgumentException("Motor de base de datos no soportado: " + tipoDB);
    }
}
