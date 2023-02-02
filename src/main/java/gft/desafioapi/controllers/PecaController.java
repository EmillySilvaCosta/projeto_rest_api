package gft.desafioapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.desafioapi.dto.fornecedor.ConsultaFornecedorDTO;
import gft.desafioapi.dto.fornecedor.FornecedorMapper;
import gft.desafioapi.dto.peca.ConsultaPecaDTO;
import gft.desafioapi.dto.peca.PecaMapper;
import gft.desafioapi.dto.peca.RegistroPecaDTO;
import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.entities.Peca;
import gft.desafioapi.services.PecaService;

@RestController
@RequestMapping("/v1/pecas")
public class PecaController {

	private final PecaService pecaService;

	public PecaController(PecaService pecaService) {
		this.pecaService = pecaService;
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping
	public ResponseEntity<List<ConsultaPecaDTO>> buscarTodasAsPecas(@PageableDefault Pageable pageable) {

		List<Peca> pecas = pecaService.listarTodasAsPecas();
		return ResponseEntity.ok(pecas.stream().map(PecaMapper::fromEntity).collect(Collectors.toList()));

	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@PostMapping
	public ResponseEntity<ConsultaPecaDTO> salvarPeca(@RequestBody RegistroPecaDTO dto) {

		Peca peca = pecaService.salvarPeca(PecaMapper.fromDTO(dto));

		return ResponseEntity.ok(PecaMapper.fromEntity(peca));

	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping("/classificacaoFornecedor/{id}")
	public ResponseEntity<List<ConsultaFornecedorDTO>> listarFornecedoresPecaPorClassificacao(@PathVariable Long id) {
		List<Fornecedor> fornecedores = pecaService.listarFornecedorPorPeca(id);
		return ResponseEntity.ok(fornecedores.stream().map(FornecedorMapper::fromEntity).collect(Collectors.toList()));

	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping("/estoqueAlerta")
	public ResponseEntity<List<ConsultaPecaDTO>> listarPecasComAlerta() {
		List<Peca> pecas = pecaService.listarTodasAsPecasComAlertaEstoque();
		return ResponseEntity.ok(pecas.stream().map(PecaMapper::fromEntity).collect(Collectors.toList()));

	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@PutMapping("{id}")
	public ResponseEntity<ConsultaPecaDTO> alterarPeca(@RequestBody RegistroPecaDTO dto, @PathVariable Long id) {

		try {

			Peca peca = pecaService.alterarPeca(PecaMapper.fromDTO(dto), id);

			return ResponseEntity.ok(PecaMapper.fromEntity(peca));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}

	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaPecaDTO> excluirPeca(@PathVariable Long id) {

		try {
			pecaService.excluirPeca(id);

			return ResponseEntity.ok().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}

	}

}
