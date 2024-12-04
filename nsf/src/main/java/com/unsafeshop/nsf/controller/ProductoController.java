package com.unsafeshop.nsf.controller;


import com.unsafeshop.nsf.model.Producto;
import com.unsafeshop.nsf.model.Usuario;
import com.unsafeshop.nsf.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;


    @GetMapping("")
    public String show(){
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto) {
        LOGGER.info("Este es el objeto producto {}",producto);
        Usuario u=new Usuario(1,"","","","","","","");
        producto.setUsuario(u);
        productoService.save(producto);
        return "redirect:/productos";
    }
}
