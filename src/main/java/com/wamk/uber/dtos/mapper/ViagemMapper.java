package com.wamk.uber.dtos.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wamk.uber.dtos.ViagemDTO;
import com.wamk.uber.dtos.input.ViagemInputDTO;
import com.wamk.uber.entities.Motorista;
import com.wamk.uber.entities.Passageiro;
import com.wamk.uber.entities.Usuario;
import com.wamk.uber.entities.Viagem;
import com.wamk.uber.services.UsuarioService;

@Component
public class ViagemMapper {
	
	@Autowired
	private UsuarioService usuarioService;

	public ViagemDTO toDTO(Viagem viagem) {
		if(viagem == null) {
			return null;
		}
		return new ViagemDTO(viagem);
	}
	
	public Viagem toEntity(ViagemInputDTO viagemInputDTO) {
		if(viagemInputDTO == null) {
			return null;
		}
		var viagem = new Viagem();
		if(viagemInputDTO.getId() != null) {
			viagem.setId(viagemInputDTO.getId());
		}
		Usuario passageiro = usuarioService.findById(viagemInputDTO.getPassageiroId());
		Usuario motorista = usuarioService.findById(viagemInputDTO.getMotoristaId());
		
		viagem.setOrigem(viagemInputDTO.getOrigem());
		viagem.setDestino(viagemInputDTO.getDestino());
		viagem.setTempoDeViagem(viagemInputDTO.getTempoDeViagem());
		viagem.setPassageiro((Passageiro) passageiro);
		viagem.setMotorista((Motorista) motorista);
		return viagem;
	}
}