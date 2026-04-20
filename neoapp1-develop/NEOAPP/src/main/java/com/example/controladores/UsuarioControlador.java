package com.example.controladores;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.servicios.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.example.NEOAPP.modelos.Usuario;
import java.util.List;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Usuario datosUsuario){
       return ResponseEntity.status(HttpStatus.CREATED).body
       (usuarioService.guardar_usuario(datosUsuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioService.listar_usuarios());
        
    }
      
}