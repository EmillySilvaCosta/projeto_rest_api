package gft.desafioapi.controllers;

import gft.desafioapi.dto.fornecedor.ConsultaFornecedorDTO;
import gft.desafioapi.dto.fornecedor.FornecedorMapper;
import gft.desafioapi.dto.fornecedor.RegistroFornecedorDTO;
import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.services.FornecedorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/fornecedores")
public class FornecedorController {
	
private final FornecedorService fornecedorService;
	
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<Page<ConsultaFornecedorDTO>> buscarTodosOsFornecedors(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(fornecedorService.listarTodosOsFornecedores(pageable).map(FornecedorMapper::fromEntity));
			
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ConsultaFornecedorDTO> salvarFornecedor(@RequestBody RegistroFornecedorDTO dto) throws Exception{
		
		Fornecedor fornecedor = fornecedorService.salvarFornecedor(FornecedorMapper.fromDTO(dto));
		
		return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("{id}") 
	public ResponseEntity<ConsultaFornecedorDTO> buscarFornecedor(@PathVariable Long id){

		Fornecedor fornecedor = fornecedorService.buscarFornecedor(id);
		
		return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
		
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<ConsultaFornecedorDTO> alterarFornecedor(@RequestBody RegistroFornecedorDTO dto,
			@PathVariable Long id){
		
		try {
		
			Fornecedor fornecedor = fornecedorService.alterarFornecedor(FornecedorMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaFornecedorDTO> excluirFornecedor(@PathVariable Long id){
		
		try {
			fornecedorService.excluirFornecedor(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
