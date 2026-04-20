package com.example.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.repositorio.CategoriaRepository;
import com.example.NEOAPP.modelos.Categoria;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repositorio;

    //servicio para guardar una categoria
    public boolean guardar_categoria(Categoria datosCategoria) {
        if (datosCategoria.getNombre() == null || datosCategoria.getNombre().isBlank() || datosCategoria.getNombre().isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }
        
        try {
            repositorio.save(datosCategoria);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //servicio para listar todas las categorias en BD
    public List<Categoria> listar_categorias() {
        return repositorio.findAll();
    }
}
