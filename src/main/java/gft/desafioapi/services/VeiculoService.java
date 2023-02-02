package gft.desafioapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.desafioapi.entities.Veiculo;
import gft.desafioapi.repositories.VeiculoRepository;

@Service
public class VeiculoService {
    
	@Autowired
    private VeiculoRepository veiculoRepository;
	
	public Veiculo salvarVeiculo(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
		veiculo.setStatusVeiculo();
		veiculo.setValorTotalPecasVeiculo();
		veiculo.setValorTotalInsumosVeiculo();
		veiculo.setValorTotalProducaoVeiculo();
		veiculo.setPorcentagemLucroVeiculo();
		veiculo.getValorTotalEstoqueGeralVeiculo();
		return veiculoRepository.save(veiculo);
	}
	
	public Page<Veiculo> listarTodosOsVeiculos(Pageable pageable){
		
		return veiculoRepository.findAll(pageable);
		
	}

	public Veiculo buscarVeiculo(Long id) {
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		
		return optional.orElseThrow(() -> new EntityNotFoundException("Veiculo não encontrado") );
		
	}
	
	public Veiculo alterarVeiculo(Veiculo veiculo, Long id) {
		
		Veiculo veiculoOriginal = this.buscarVeiculo(id);
		
		veiculo.setId_veiculo(veiculoOriginal.getId_veiculo());
		
		return salvarVeiculo(veiculoOriginal);
		
	}

	public void excluirVeiculo(Long id) {
		Veiculo veiculoOriginal = this.buscarVeiculo(id);
		
		veiculoRepository.delete(veiculoOriginal);
		
	}
}
