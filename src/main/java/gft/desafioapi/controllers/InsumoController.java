package gft.desafioapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import gft.desafioapi.dto.insumo.ConsultaInsumoDTO;
import gft.desafioapi.dto.insumo.InsumoMapper;
import gft.desafioapi.dto.insumo.RegistroInsumoDTO;
import gft.desafioapi.entities.Insumo;
import gft.desafioapi.services.InsumoService;

@RestController
@RequestMapping("/v1/insumos")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ConsultaInsumoDTO> salvarInsumo(@RequestBody RegistroInsumoDTO dto){
        Insumo insumo = this.insumoService.salvarInsumo(InsumoMapper.fromDTO(dto));

        return ResponseEntity.ok(InsumoMapper.fromEntity(insumo));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<Page<ConsultaInsumoDTO>> buscarTodosOsInsumos(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.insumoService.buscarTodosOsInsumos(pageable).map(InsumoMapper::fromEntity));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/classificacao")
    public ResponseEntity<List<ConsultaInsumoDTO>> buscarInsumoPorClassificacao() {
        List<Insumo> insumos = this.insumoService.findAllInsumoControllerPorClassificacao();
        return ResponseEntity.ok(insumos.stream().map(InsumoMapper::fromEntity).collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<ConsultaInsumoDTO> buscarInsumo(@PathVariable Long id){
        Insumo insumo = this.insumoService.buscarInsumo(id);

        return ResponseEntity.ok(InsumoMapper.fromEntity(insumo));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<ConsultaInsumoDTO> alterarInsumo(@RequestBody RegistroInsumoDTO dto, @PathVariable Long id){
        try {
            Insumo insumo = this.insumoService.alterarInsumo(InsumoMapper.fromDTO(dto), id);
            return ResponseEntity.ok(InsumoMapper.fromEntity(insumo));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaInsumoDTO> excluirInsumo(@PathVariable Long id){
        try {
            this.insumoService.excluirInsumo(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
