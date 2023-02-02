package gft.desafioapi.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.desafioapi.entities.Insumo;
import gft.desafioapi.repositories.InsumoRepository;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    public Insumo salvarInsumo(Insumo insumo){
        return this.insumoRepository.save(insumo);
    }

    public Page<Insumo> buscarTodosOsInsumos(Pageable pageable){
        return this.insumoRepository.findAll(pageable);
    }

    public List<Insumo> findAllInsumoControllerPorClassificacao(){
        List<Insumo> insumos = this.insumoRepository.findAll();
        insumos.sort(Comparator.comparing(Insumo::getClassificacao));
		return insumos;
    }

    public Insumo buscarInsumo(Long id){
        Optional<Insumo> optional = this.insumoRepository.findById(id);

        return optional.orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Insumo alterarInsumo(Insumo insumo, Long id){
        Insumo aux = this.buscarInsumo(id);

        insumo.setId_insumo(aux.getId_insumo());

        return this.insumoRepository.save(insumo);
    }

    public void excluirInsumo(Long id){
        Insumo insumo = this.buscarInsumo(id);

        this.insumoRepository.delete(insumo);
    }
}