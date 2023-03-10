package gft.desafioapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.desafioapi.entities.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long>{
}
