package br.com.correios.api.postagem.converter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import br.com.correios.api.postagem.ClienteEmpresa;
import br.com.correios.api.postagem.Contrato;
import br.com.correios.api.postagem.GerenteDeConta;
import br.com.correios.api.postagem.Status;
import br.com.correios.webservice.postagem.ClienteERP;
import br.com.correios.webservice.postagem.ContratoERP;
import br.com.correios.webservice.postagem.GerenteConta;

public class ClienteRetornadoDosCorreiosToClienteConverter {

	public ClienteEmpresa convert(ClienteERP clienteRetornadoDosCorreios) {
		XMLGregorianCalendar dataDeAtualizacaoNosCorreios = clienteRetornadoDosCorreios.getDataAtualizacao();
		Calendar dataDeAtualizacaoDoCliente = null;
		if (dataDeAtualizacaoNosCorreios != null) {
			dataDeAtualizacaoDoCliente = dataDeAtualizacaoNosCorreios.toGregorianCalendar();
		}

		ContratoWebServiceToContratoCorreiosConverter converter = new ContratoWebServiceToContratoCorreiosConverter();
		List<Contrato> contratos = new ArrayList<>();
		for (ContratoERP contrato : clienteRetornadoDosCorreios.getContratos()) {
			contratos.add(converter.convert(contrato));
		}

		GerenteDeContaWebServiceToGerenteDeContaConverter gerenteConverter = new GerenteDeContaWebServiceToGerenteDeContaConverter();
		List<GerenteDeConta> gerentes = new ArrayList<>();
		for (GerenteConta gerenteWebService: clienteRetornadoDosCorreios.getGerenteConta()) {
			gerentes.add(gerenteConverter.convert(gerenteWebService));
		}

		ClienteEmpresa empresa = ClienteEmpresa
			.novoCliente()
			.comId(clienteRetornadoDosCorreios.getId())
			.comNome(clienteRetornadoDosCorreios.getNome())
			.comCnpj(clienteRetornadoDosCorreios.getCnpj())
			.possuindoOsContratos(contratos)
			.atualizadoNaData(dataDeAtualizacaoDoCliente)
			.comStatus(new Status(clienteRetornadoDosCorreios.getDescricaoStatusCliente(), clienteRetornadoDosCorreios.getStatusCodigo()))
			.pertencendoAosGerentes(gerentes)
			.comInscricaoEstadual(clienteRetornadoDosCorreios.getInscricaoEstadual())
			.build();

		return empresa;
	}

}