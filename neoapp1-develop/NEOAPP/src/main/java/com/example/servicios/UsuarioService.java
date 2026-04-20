package com.example.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repositorio.UsuarioRepository;
import com.example.NEOAPP.modelos.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardar_usuario(Usuario datosUsuario){
        
        // --- Validaciones agregadas por ti ---
        if(datosUsuario.getNombres() == null || datosUsuario.getNombres().isBlank() || datosUsuario.getNombres().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del usuario es obligatorio");
        }
        
        if (datosUsuario.getDocumento() == null || datosUsuario.getDocumento().isBlank() || datosUsuario.getDocumento().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El documento del usuario es obligatorio");
        }

        // Corregido: tu modelo usa getCorreoElectronico() en lugar de getCorreo()
        if (datosUsuario.getCorreoElectronico() == null || datosUsuario.getCorreoElectronico().isBlank() || datosUsuario.getCorreoElectronico().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo del usuario es obligatorio");
        }

        if (datosUsuario.getTelefono() == null || datosUsuario.getTelefono().isBlank() || datosUsuario.getTelefono().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El telefono del usuario es obligatorio");
        }

        if (datosUsuario.getDireccion() == null || datosUsuario.getDireccion().isBlank() || datosUsuario.getDireccion().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La direccion del usuario es obligatoria");
        }
        // ------------------------------------

        try {
            return usuarioRepository.save(datosUsuario);
        } catch (Exception e) {
            return null;
        }
    }

    // Restaurado de tu código anterior
    public List<Usuario> listar_usuarios() {
        return usuarioRepository.findAll();
    }
    public List<Usuario> listar_usuarios_activos() {
        return usuarioRepository.findAll();
    }
}