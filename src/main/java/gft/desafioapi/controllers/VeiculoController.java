package gft.desafioapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import gft.desafioapi.dto.veiculo.ConsultaVeiculoDTO;
import gft.desafioapi.dto.veiculo.RegistroVeiculoDTO;
import gft.desafioapi.dto.veiculo.VeiculoMapper;
import gft.desafioapi.entities.Veiculo;
import gft.desafioapi.services.VeiculoService;

@RestController
@RequestMapping("/v1/veiculos")
public class VeiculoController {

	@Autowired
    private VeiculoService veiculoService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<Page<ConsultaVeiculoDTO>> buscarTodosOsVeiculos(@PageableDefault Pageable pageable){
		return ResponseEntity.ok(veiculoService.listarTodosOsVeiculos(pageable).map(VeiculoMapper::fromEntity));		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ConsultaVeiculoDTO> salvarVeiculo(@RequestBody RegistroVeiculoDTO dto){
		Veiculo veiculo = veiculoService.salvarVeiculo(VeiculoMapper.fromDTO(dto));
		return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("{id}") 
	public ResponseEntity<ConsultaVeiculoDTO> buscarVeiculo(@PathVariable Long id){
		Veiculo veiculo = veiculoService.buscarVeiculo(id);
		return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<ConsultaVeiculoDTO> alterarVeiculo(@RequestBody RegistroVeiculoDTO dto,
			@PathVariable Long id){
		try {
			Veiculo veiculo = veiculoService.alterarVeiculo(VeiculoMapper.fromDTO(dto), id);
			return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaVeiculoDTO> excluirVeiculo(@PathVariable Long id){
		try {
			veiculoService.excluirVeiculo(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
