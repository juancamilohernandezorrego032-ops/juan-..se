package com.example.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.repositorio.ComercioRepository;
import com.example.NEOAPP.modelos.Comercio;
import java.util.List;

@Service
public class ComercioService {

    @Autowired
    private ComercioRepository repositorio;

    //servicio para guardar un comercio
    public boolean guardar_comercio(Comercio datosComercio) {
        if (datosComercio.getNombre() == null || datosComercio.getNombre().isBlank() || datosComercio.getNombre().isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }
        
        try {
            repositorio.save(datosComercio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //servicio para listar todos los comercios en BD
    public List<Comercio> listar_comercios() {
        return repositorio.findAll();
    }
}
