package gft.desafioapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.desafioapi.entities.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
    
    Page<Insumo> findAll(Pageable pageable);
}
