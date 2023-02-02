package gft.desafioapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gft.desafioapi.entities.Classificacao;
import gft.desafioapi.entities.Cliente;
import gft.desafioapi.entities.Endereco;
import gft.desafioapi.entities.Fornecedor;
import gft.desafioapi.entities.Insumo;
import gft.desafioapi.entities.Peca;
import gft.desafioapi.entities.Veiculo;
import gft.desafioapi.repositories.ClienteRepository;
import gft.desafioapi.repositories.FornecedorRepository;
import gft.desafioapi.repositories.InsumoRepository;
import gft.desafioapi.repositories.PecaRepository;
import gft.desafioapi.repositories.VeiculoRepository;

@SpringBootApplication
public class DesafioapiApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PecaRepository pecaRepository;

	@Autowired
	private InsumoRepository insumoRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioapiApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente(null, "Jessica Nagata", "jessica@gft.com", "015.777.888-99",
				new Endereco("Rua A", "777", "apto 105", "50060-080"));
		Cliente c2 = new Cliente(null, "Julia Gubolin", "julia@gft.com", "013.873.555-44",
				new Endereco("Rua A", "777", "apto 105", "50060-080"));
		Cliente c3 = new Cliente(null, "Isabella Suto", "isabella@gft.com", "111.222.333-55",
				new Endereco("Rua A", "777", "apto 105", "50060-080"));
		Cliente c4 = new Cliente(null, "Emily Costa", "emily@gft.com", "777.999.111-22",
				new Endereco("Rua A", "777", "apto 105", "50060-080"));
		Cliente c5 = new Cliente(null, "Alessandra Cruz", "alessandra@gft.com", "777.999.666-11",
				new Endereco("Rua A", "777", "apto 105", "50060-080"));
		clienteRepository.saveAll(List.of(c1, c2, c3, c4, c5));

		Peca p1 = new Peca(null, "Combo Fusquinha", "Produção própria", 10, 20, 15, 8000.0, "EXECELENTE", null, null, null);
		Peca p2 = new Peca(null, "Combo Gol", "Produção própria", 10, 20, 15, 8000.0, "EXECELENTE", null, null, null);
		Peca p3 = new Peca(null, "Combo Kombi", "Produção própria", 10, 20, 15, 8000.0, "EXECELENTE", null, null, null);
		Peca p4 = new Peca(null, "Combo Jetta", "Produção própria", 10, 20, 15, 8000.0, "EXECELENTE", null, null, null);
		Peca p5 = new Peca(null, "Combo Camaro", "Produção própria", 10, 20, 15, 8000.0, "EXECELENTE", null, null, null);
		Peca p6 = new Peca(null, "Farol Led", "Nacional", 10, 20, 15, 100.0, "BOM", null, null, null);
		Peca p7 = new Peca(null, "Farol Led", "Importado", 10, 20, 15, 100.0, "BOM", null, null, null);
		Peca p8 = new Peca(null, "Bateria", "Importado", 10, 20, 15, 500.0, "RUIM", null, null, null);
		Peca p9 = new Peca(null, "Bateria", "Nacional", 10, 20, 15, 500.0, "EXECELENTE", null, null, null);
		Peca p10 = new Peca(null, "Correia", "Nacional", 10, 20, 15, 50.0, "OTIMO", null, null, null);
		Peca p11 = new Peca(null, "Correia", "Importado", 10, 20, 15, 50.0, "EXECELENTE", null, null, null);
		Peca p12 = new Peca(null, "Filtro de Oleo", "Nacional", 10, 20, 15, 200.0, "EXECELENTE", null, null, null);
		Peca p13 = new Peca(null, "Filtro de Oleo", "Importado", 10, 20, 15, 200.0, "EXECELENTE", null, null, null);
		Peca p14 = new Peca(null, "Carpete", "Importado", 10, 20, 15, 700.0, "REGULAR", null, null, null);
		Peca p15 = new Peca(null, "Carpete", "Nacional", 10, 20, 15, 700.0, "EXECELENTE", null, null, null);
		Peca p16 = new Peca(null, "Banco Frontal", "Importado", 10, 20, 15, 700.0, "REGULAR", null, null, null);
		Peca p17 = new Peca(null, "Banco Frontal", "Nacional", 10, 20, 15, 700.0, "OTIMO", null, null, null);
		Peca p18 = new Peca(null, "Banco Braseiro", "Importado", 10, 20, 15, 700.0, "EXECELENTE", null, null, null);
		Peca p19 = new Peca(null, "Banco Braseiro", "Nacional", 10, 20, 15, 700.0, "OTIMO", null, null, null);
		Peca p20 = new Peca(null, "Volante", "Importado", 10, 20, 15, 700.0, "EXECELENTE", null, null, null);
		Peca p21 = new Peca(null, "Volante", "Nacional", 10, 20, 15, 70.0, "OTIMO", null, null, null);
		Peca p22 = new Peca(null, "Painel de Bordo", "Nacional", 10, 20, 15, 80.0, "EXECELENTE", null, null, null);
		Peca p23 = new Peca(null, "Computador de Bordo", "Importado", 10, 20, 15, 90.0, "REGULAR", null, null, null);
		Peca p24 = new Peca(null, "Computador de Bordo", "Nacional", 10, 20, 15, 180.0, "EXECELENTE", null, null, null);
		Peca p25 = new Peca(null, "Painel de Bordo", "Importado", 10, 20, 15, 150.0, "EXECELENTE", null, null, null);
		Peca p26 = new Peca(null, "Carroceria Personalizada", "Importado", 10, 20, 15, 3300.0, "RUIM", null, null, null);
		Peca p27 = new Peca(null, "Carroceria Personalizada", "Nacional", 10, 20, 15, 2200.0, "EXECELENTE", null, null, null);
		Peca p28 = new Peca(null, "Vidro Fumê", "Nacional", 10, 20, 15, 900.0, "OTIMO", null, null, null);
		Peca p29 = new Peca(null, "Vidro Fumê", "Importado", 10, 20, 15, 400.0, "OTIMO", null, null, null);
		Peca p30 = new Peca(null, "Rastreador", "Nacional", 10, 20, 15, 400.0, "OTIMO", null, null, null);
		Peca p31 = new Peca(null, "Peça Estoque Abaixo", "Nacional", 10, 20, 2, 400.0, "OTIMO", null, null, null);
		pecaRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18,
				p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31));

		Insumo i1 = new Insumo(null, "Imposto", null, 100.0, Classificacao.C, null);
		Insumo i2 = new Insumo(null, "Mão de obra", null, 200000.0, Classificacao.A, null);
		Insumo i3 = new Insumo(null, "Estabelecimento", null, 3000.0, Classificacao.B, null);
		insumoRepository.saveAll(List.of(i1, i2, i3));

		Fornecedor f1 = new Fornecedor(null, "Empresa Própria", "27.119.334/0001-35", 10, Classificacao.B,
				new Endereco("Rua A", "777", "apto 105", "50060-080"), null,
				null, null);
		Fornecedor f2 = new Fornecedor(null, "Governo", "03.080.900/0001-00", 10, Classificacao.B,
				new Endereco("Rua A", "777", "apto 105", "50060-080"), null, null,
				null);
		Fornecedor f3 = new Fornecedor(null, "Empresa Terceirizada", "15.119.333/0001-35", 10, Classificacao.B,
				new Endereco("Rua A", "777", "apto 105", "50060-080"),
				null, null, null);
		fornecedorRepository.saveAll(List.of(f1, f2, f3));

		Veiculo v1 = new Veiculo(null, "Jetta", "Produção própria", 3, 10, 5, null, null, null, null, 187373.0);
		Veiculo v2 = new Veiculo(null, "Camaro", "Produção própria", 4, 10, 5, null, null, null, null, 123.4);
		Veiculo v3 = new Veiculo(null, "Carro do Seu Jose", "Nacional", 4, 10, 5, null, null, null, null, 5678.6);
		Veiculo v4 = new Veiculo(null, "Carro de Dona Maria", "Importado", 5, 10, 5, null, null, null, null, 73816.7);
		veiculoRepository.saveAll(List.of(v1, v2, v3, v4));
		veiculoRepository.save(v1);
	}
}
