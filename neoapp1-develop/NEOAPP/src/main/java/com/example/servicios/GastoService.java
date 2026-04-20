package com.example.servicios;

import com.example.NEOAPP.modelos.Gasto;
import com.example.repositorio.GastoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class GastoService {

    @Autowired
    private GastoRepository repositorio;

   public Gasto guardar_gasto(Gasto datosGasto){

    if (datosGasto.getValor() <= 0) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "El monto del gasto debe ser mayor a 0"
        );
    }

    if (datosGasto.getDescripcion() == null 
        || datosGasto.getDescripcion().isBlank()) {

        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "La descripcion es obligatoria"
        );
    }

    return repositorio.save(datosGasto);
}
}
