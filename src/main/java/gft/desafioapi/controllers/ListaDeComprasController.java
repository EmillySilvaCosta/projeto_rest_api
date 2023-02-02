package gft.desafioapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.desafioapi.dto.peca.ConsultaPecaDTO;
import gft.desafioapi.dto.peca.PecaMapper;
import gft.desafioapi.entities.Peca;
import gft.desafioapi.services.PecaService;

@RestController
@RequestMapping("/v1/compras")
public class ListaDeComprasController {

	private final PecaService pecaService;

	public ListaDeComprasController(PecaService pecaService) {
		this.pecaService = pecaService;
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
	@GetMapping
	public ResponseEntity<List<ConsultaPecaDTO>> buscarTodasAsPecasComEstoqueBaixo(@PageableDefault Pageable pageable) {

        List<Peca> listarPecasEstoqueBaixo = pecaService.listarPecasEstoqueBaixo();
		return ResponseEntity.ok(listarPecasEstoqueBaixo.stream().map(PecaMapper::fromEntity).collect(Collectors.toList()));

	}
}
