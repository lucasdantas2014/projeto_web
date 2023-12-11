package anuncio.ifpb.api.carro;

public record DadosListagemCarro(
		Long id, 
		String nome, 
		String marca,
		String cor,
		String descricao,
		Long idAnuncio
		) {

	public DadosListagemCarro(Carro carro) {
		this(carro.getId(), 
			carro.getNome(), 
			carro.getMarca(), 
			carro.getCor(),
			carro.getDescricao(),
			(carro.getAnuncio() == null) ? null : carro.getAnuncio().getId()
			);
	}

}
