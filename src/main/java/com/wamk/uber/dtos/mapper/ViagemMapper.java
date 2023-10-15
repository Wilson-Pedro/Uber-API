package com.wamk.uber.dtos.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wamk.uber.dtos.ViagemDTO;
import com.wamk.uber.dtos.input.ViagemInputDTO;
import com.wamk.uber.entities.Motorista;
import com.wamk.uber.entities.Passageiro;
import com.wamk.uber.entities.Usuario;
import com.wamk.uber.entities.Viagem;
import com.wamk.uber.enums.FormaDePagamento;
import com.wamk.uber.enums.ViagemStatus;
import com.wamk.uber.services.UsuarioService;

@Component
public class ViagemMapper {

	public ViagemDTO toDTO(Viagem viagem) {
		if(viagem == null) {
			return null;
		}
		return new ViagemDTO(viagem);
	}
	
	public Viagem toEntity(ViagemInputDTO viagemInputDTO, Passageiro passageiro, Motorista motorista) {
		if(viagemInputDTO == null) {
			return null;
		}
		var viagem = new Viagem();
		if(viagemInputDTO.getId() != null) {
			viagem.setId(viagemInputDTO.getId());
		}
		
		viagem.setOrigem(viagemInputDTO.getOrigem());
		viagem.setDestino(viagemInputDTO.getDestino());
		viagem.setTempoDeViagem(viagemInputDTO.getTempoDeViagem());
		viagem.setPassageiro((Passageiro) passageiro);
		viagem.setMotorista((Motorista) motorista);
		viagem.setFormaDePagamento(FormaDePagamento.toEnum(viagemInputDTO.getFormaDePagamento()));
		viagem.setViagemStatus(ViagemStatus.NAO_FINALIZADA);
		return viagem;
	}
}
