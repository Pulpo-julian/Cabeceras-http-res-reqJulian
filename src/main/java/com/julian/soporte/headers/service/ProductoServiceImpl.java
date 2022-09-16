package com.julian.soporte.headers.service;

import java.util.Arrays;
import java.util.List;

import com.julian.soporte.headers.models.Producto;

public class ProductoServiceImpl implements ProductoService{

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return Arrays.asList(new Producto(1L, "acer notebook", "pc", 2500),
				new Producto(2L, "macbook pro", "pc", 5500),
				new Producto(3L, "teclado pc", "accesorio", 6800));
	}
	
	

}
