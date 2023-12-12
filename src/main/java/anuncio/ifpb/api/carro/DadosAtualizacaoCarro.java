package anuncio.ifpb.api.carro;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCarro(
		@NotNull
        Long id,
        String nome,
        String marca,
        String cor,
        String descricao,
        Long idAnuncio,
		Long userId
	) {

	

}
