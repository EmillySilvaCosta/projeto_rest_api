package gft.desafioapi.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.entities.Peca;
import gft.desafioapi.repositories.ListaDeComprasRepository;
import gft.desafioapi.repositories.PecaRepository;

@Service
public class PecaService {

	private final PecaRepository pecaRepository;
	private final ListaDeComprasRepository listaDeComprasRepository;
	
	public PecaService(PecaRepository pecaRepository, ListaDeComprasRepository listaDeComprasRepository) {
		this.pecaRepository = pecaRepository;
		this.listaDeComprasRepository = listaDeComprasRepository;
	}
	
	public Peca salvarPeca(Peca peca) {
		pecaRepository.save(peca);

		peca.setStatusEstoque();
		
		return pecaRepository.save(peca);
		
	}
	
	public List<Peca> listarTodasAsPecas(){
		
		return pecaRepository.findAll();
		
	}

	public List<Peca> listarTodasAsPecasComAlertaEstoque(){
		List<Peca> pecasTotais = listaDeComprasRepository.findAll();
		List<Peca> pecasEstoqueAlerta = new ArrayList<Peca>();
		for (Peca peca : pecasTotais) {
			if(peca.getStatusEstoque().equals("ABAIXO, COMPRAR") || peca.getStatusEstoque().equals("ACIMA, VENDER") ){
				pecasEstoqueAlerta.add(peca);
			}
		}
		return pecasEstoqueAlerta;
	}

	public Peca buscarPeca(Long id) {
		Optional<Peca> optional = pecaRepository.findById(id);
		
		return optional.orElseThrow(() -> new EntityNotFoundException("Peca não encontrado") );
		
	}
	
	public Peca alterarPeca(Peca peca, Long id) {
		
		Peca pecaOriginal = this.buscarPeca(id);
		
		peca.setId_peca(pecaOriginal.getId_peca());
		
		return pecaRepository.save(peca);
		
	}

	public void excluirPeca(Long id) {
		Peca pecaOriginal = this.buscarPeca(id);
		
		pecaRepository.delete(pecaOriginal);
		
	}

    public List<Fornecedor> listarFornecedorPorPeca(Long id) {

		Optional<Peca> pecas = pecaRepository.findById(id);
		List<Fornecedor> fornecedores = pecas.get().getFornecedores();
		fornecedores.sort(Comparator.comparing(Fornecedor::getClassificacao));
		return fornecedores;
	}

    public List<Peca> listarPecasEstoqueBaixo() {
        List<Peca> pecasTotais = listaDeComprasRepository.findAll();
		List<Peca> pecasEstoqueAbaixo = new ArrayList<Peca>();
		for (Peca peca : pecasTotais) {
			if(peca.getStatusEstoque().equals("ABAIXO, COMPRAR") ){
				pecasEstoqueAbaixo.add(peca);
			}
		}
		return pecasEstoqueAbaixo;
    }
}
