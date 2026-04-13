package com.example.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.repositorio.GastoRepository;
import com.example.NEOAPP.modelos.Gasto;
import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository repositorio;

    //servicio para guardar un gasto
    public boolean guardar_gasto(Gasto datosGasto) {
        if (datosGasto.getDescripcion() == null || datosGasto.getDescripcion().isBlank() || datosGasto.getDescripcion().isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }
        
        try {
            repositorio.save(datosGasto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //servicio para listar todos los gastos en BD
    public List<Gasto> listar_gastos() {
        return repositorio.findAll();
    }
}
