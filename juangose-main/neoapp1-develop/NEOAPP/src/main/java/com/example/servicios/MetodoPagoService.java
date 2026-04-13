package com.example.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.repositorio.MetodoPagoRepository;
import com.example.NEOAPP.modelos.MetodoPago;
import java.util.List;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository repositorio;

    public MetodoPago guardar_metodo_pago(MetodoPago datosMetodoPago) {
        
        // --- Validaciones agregadas similares a Usuario ---
        if (datosMetodoPago.getNombre() == null || datosMetodoPago.getNombre().isBlank() || datosMetodoPago.getNombre().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del metodo de pago es obligatorio");
        }

        if (datosMetodoPago.getFranquicia() == null || datosMetodoPago.getFranquicia().isBlank() || datosMetodoPago.getFranquicia().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La franquicia del metodo de pago es obligatoria");
        }

        if (datosMetodoPago.getEstado() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El estado del metodo de pago es obligatorio");
        }
        
        try {
            return repositorio.save(datosMetodoPago);
        } catch (Exception e) {
            return null;
        }
    }

    public List<MetodoPago> listar_metodos_pago() {
        return repositorio.findAll();
    }

    public List<MetodoPago> listar_metodos_pago_activos() {
        return repositorio.findAll();
    }
}
