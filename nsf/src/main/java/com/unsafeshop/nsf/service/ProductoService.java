package com.unsafeshop.nsf.service;

import com.unsafeshop.nsf.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public Producto save(Producto producto);
    public Optional<Producto> get(Integer Id);
    public void update(Producto producto);
    public void delete(Integer id);
    public List<Producto> findAll();
}
