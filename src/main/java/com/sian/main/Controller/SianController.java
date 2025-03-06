package com.sian.main.Controller;

import com.sian.main.Exception.RecordNotFoundException;
import com.sian.main.Model.sian;
import com.sian.main.Repos.SianRepo;
import com.sian.main.services.SianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sian/Articulo")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class SianController {

    @Autowired
    private SianService sianService;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<sian>> getProductByName(@PathVariable("name") String name)
            throws RecordNotFoundException {
        List<sian> entity = sianService.obtenerProductoPorNombre(name);

        if (entity.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/product/{idArticulo}")
    public ResponseEntity<sian> obtenerProductoPorId(@PathVariable String idArticulo) {
        List<sian> producto = sianService.findById(idArticulo);

        return producto.stream().map(ResponseEntity::ok)
                .findAny().orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<sian>> buscarPorNombre(@PathVariable String nombre) {
        List<sian> productos = sianService.buscarPorNombre(nombre);
        return productos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(productos);
    }



}