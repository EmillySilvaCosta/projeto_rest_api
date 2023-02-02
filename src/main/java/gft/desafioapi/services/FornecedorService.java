package gft.desafioapi.services;

import gft.desafioapi.entities.CepResponse;
import gft.desafioapi.entities.Endereco;
import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.repositories.FornecedorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class FornecedorService {
	
private final FornecedorRepository fornecedorRepository;
	
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	
	public Fornecedor salvarFornecedor(Fornecedor fornecedor) throws Exception {

		CepServiceImpl buscaCep = new CepServiceImpl();
		fornecedorRepository.save(fornecedor);
		CepResponse cep = buscaCep.buscaCep(fornecedor.getEndereco().getCep());
		fornecedor.setEndereco(new Endereco(cep.getLogradouro(), fornecedor.getEndereco().getNumero(), fornecedor.getEndereco().getComplemento(), cep.getCep()));
		
		return fornecedorRepository.save(fornecedor);
		
	}
	
	
	
	public Page<Fornecedor> listarTodosOsFornecedores(Pageable pageable){
		
		return fornecedorRepository.findAll(pageable);
		
	}

	public Fornecedor buscarFornecedor(Long id) {
		Optional<Fornecedor> optional = fornecedorRepository.findById(id);
		
		return optional.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado") );
		
	}
	
	public Fornecedor alterarFornecedor(Fornecedor fornecedor, Long id) {
		
		Fornecedor fornecedorOriginal = this.buscarFornecedor(id);
		
		fornecedor.setId(fornecedorOriginal.getId());
		
		return fornecedorRepository.save(fornecedor);
		
	}

	public void excluirFornecedor(Long id) {
		Fornecedor fornecedorOriginal = this.buscarFornecedor(id);
		
		fornecedorRepository.delete(fornecedorOriginal);
		
	}

}
