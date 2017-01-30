package br.com.correios.api.postagem;

import java.util.Calendar;
import java.util.List;

import br.com.correios.webservice.postagem.Cliente;

public class Contrato {

    private List<CartaoPostagem> cartoesPostagem;

    //TODO Este cliente ja possui um contrato. Ver a possibilidade de remover daqui
    private Cliente cliente;

    private long codigoCliente;

    private ContratoDiretoria contratoDiretoria;

    private Calendar dataAtualizacao;

    private DataVigencia dataDeVigencia;

    private String descricaoDiretoriaRegional;

    private Status status;

    private UnidadePostagem unidadeDePostagem;

    private Contrato() {}

    public String getDataDaAtualizacaoFormatada() {
    	return "";
    }

    public List<CartaoPostagem> getCartoesPostagem() {
		return cartoesPostagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public long getCodigoCliente() {
		return codigoCliente;
	}

	public ContratoDiretoria getContratoDiretoria() {
		return contratoDiretoria;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public DataVigencia getDataDeVigencia() {
		return dataDeVigencia;
	}

	public String getDescricaoDiretoriaRegional() {
		return descricaoDiretoriaRegional;
	}

	public Status getStatus() {
		return status;
	}

	public UnidadePostagem getUnidadeDePostagem() {
		return unidadeDePostagem;
	}

	public static ContratoBuilder novoContrato() {
    	return new ContratoBuilder();
    }

    public static class ContratoBuilder {

    	private Contrato contrato;

    	public ContratoBuilder() {
    		this.contrato = new Contrato();
		}

		public ContratoBuilder comCartoesDePostagem(List<CartaoPostagem> cartoes) {
			this.contrato.cartoesPostagem = cartoes;
			return this;
		}

		public ContratoBuilder doCliente(Cliente cliente) {
			this.contrato.cliente = cliente;
			return this;
		}

		public ContratoBuilder comContratoDeDiretoria(ContratoDiretoria contrato) {
			this.contrato.contratoDiretoria = contrato;
			return this;
		}

		public ContratoBuilder comCodigoCliente(Long codigoCliente) {
			this.contrato.codigoCliente = codigoCliente;
			return this;
		}

		public ContratoBuilder atualizadoNaData(Calendar data) {
			this.contrato.dataAtualizacao = data;
			return this;
		}

		public ContratoBuilder comVigencia(DataVigencia vigencia) {
			this.contrato.dataDeVigencia = vigencia;
			return this;
		}

		public ContratoBuilder comDescricaoDeDiretoriaRegional(String descricao) {
			this.contrato.descricaoDiretoriaRegional = descricao;
			return this;
		}

		public ContratoBuilder comStatus(Status status) {
			this.contrato.status = status;
			return this;
		}

		public ContratoBuilder naUnidadeDePostagem(UnidadePostagem unidadePostagem) {
			this.contrato.unidadeDePostagem = unidadePostagem;
			return this;
		}

		public Contrato build() {
			return this.contrato;
		}

    }

}