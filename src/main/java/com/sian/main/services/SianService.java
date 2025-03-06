package com.sian.main.services;

import com.sian.main.Model.sian;
import com.sian.main.Repos.SianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SianService {

    @Autowired
    private SianRepo sianRepo;

    public List<sian> obtenerProductoPorNombre(String nombre) {
        return sianRepo.getByName(nombre);
    }

    public List<sian> findById(String idArticulo) {
        return sianRepo.findByID(idArticulo);
    }

    public List<sian> buscarPorNombre(String articulo) {
        return sianRepo.findByArticuloContaining(articulo);
    }

}
