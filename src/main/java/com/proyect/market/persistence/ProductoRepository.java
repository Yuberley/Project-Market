package com.proyect.market.persistence;

import com.proyect.market.persistence.crud.ProductoCrudRepository;
import com.proyect.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

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

}
