package gft.desafioapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gft.desafioapi.entities.Peca;

public interface ListaDeComprasRepository extends JpaRepository<Peca, Long>{
    
}
