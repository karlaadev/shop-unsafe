package com.unsafeshop.nsf.service;

import com.unsafeshop.nsf.model.Producto;
import com.unsafeshop.nsf.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void update(Producto producto) {
        productoRepository.save(producto);

    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);

    }
}
