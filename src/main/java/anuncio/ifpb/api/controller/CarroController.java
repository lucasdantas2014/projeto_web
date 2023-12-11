package anuncio.ifpb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anuncio.ifpb.api.anuncio.Anuncio;
import anuncio.ifpb.api.anuncio.AnuncioRepository;
import anuncio.ifpb.api.anuncio.DadosAtualizacaoAnuncio;
import anuncio.ifpb.api.anuncio.DadosCadastroAnuncio;
import anuncio.ifpb.api.anuncio.DadosListagemAnuncio;
import anuncio.ifpb.api.carro.Carro;
import anuncio.ifpb.api.carro.CarroRepository;
import anuncio.ifpb.api.carro.DadosAtualizacaoCarro;
import anuncio.ifpb.api.carro.DadosCadastroCarro;
import anuncio.ifpb.api.carro.DadosListagemCarro;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private CarroRepository repository;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrar(@Valid @RequestBody DadosCadastroCarro dados) {
		System.out.println(dados);
		repository.save(new Carro(dados));
	}

	@GetMapping("/listar")
	   public Page<DadosListagemCarro> listar(@PageableDefault(
			   size = 10) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCarro::new);
    }


	@PutMapping("/atualizar")
	@Transactional
	public void atualizar(@Valid @RequestBody DadosAtualizacaoCarro dados) {
		var carro = repository.getReferenceById(dados.id());
		carro.atualizarInformacoes(dados);
	}

	@DeleteMapping("/excluir/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
