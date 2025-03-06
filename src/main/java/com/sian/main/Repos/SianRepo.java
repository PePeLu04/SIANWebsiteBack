package com.sian.main.Repos;


import com.sian.main.Model.sian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SianRepo extends JpaRepository<sian, Long> {
    List<sian> findByFamiliaVentas(String familiaVentas);
    List<sian> findByArticuloContainingIgnoreCase(String searchTerm);

    @Query(
            value="Select * FROM sian as sian WHERE sian.Articulo LIKE %?1%",
            nativeQuery = true)
    public List<sian> getByName(String name);

        List<sian> findByArticuloContaining(String articulo);


    //findByID
    @Query(
            value="Select * FROM sian as sian WHERE sian.idArticulo=?1",
            nativeQuery = true)
    public List<sian> findByID(String idArticulo);

}