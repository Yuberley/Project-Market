package com.proyect.market.persistence;

import com.proyect.market.persistence.crud.ProductoCrudRepository;
import com.proyect.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getALL() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    // Consult a specific product with id
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    // Save a product with id
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    // Delete a product with id
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
