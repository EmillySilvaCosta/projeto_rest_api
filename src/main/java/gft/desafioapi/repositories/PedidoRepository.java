package gft.desafioapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gft.desafioapi.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
