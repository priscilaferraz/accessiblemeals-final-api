package br.com.fiap.accessiblemealapi.DTO;

import org.apache.commons.codec.binary.Base64;

import br.com.fiap.accessiblemealapi.model.Restaurante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestauranteDTO {

    private Long id;
    private String name;
    private String email;
    private String cnpj;
    private String address;
    private String typePCD;
    private String menu;
    private String profilePicture;
    private double classification;
    private Long clienteId;

    public static Restaurante toModel(RestauranteDTO dto) {
        byte[] decodedMenu = Base64.decodeBase64(dto.getMenu());
        byte[] decodedProfilePicture = Base64.decodeBase64(dto.getProfilePicture());

        return Restaurante.builder()
        .id(dto.getId())
        .name(dto.getName())
        .email(dto.getEmail())
        .cnpj(dto.getCnpj())
        .address(dto.getAddress())
        .typePCD(dto.getTypePCD())
        .menu(decodedMenu)
        .profilePicture(decodedProfilePicture)
        .classification(dto.getClassification())
        .clienteId(dto.getClienteId())
        .build();
    }

    public static RestauranteDTO toDTO(Restaurante restaurante) {
        String encodedMenu = Base64.encodeBase64String(restaurante.getMenu());
        String encodedProfilePicture = Base64.encodeBase64String(restaurante.getProfilePicture());

        return RestauranteDTO.builder()
        .id(restaurante.getId())
        .name(restaurante.getName())
        .email(restaurante.getEmail())
        .cnpj(restaurante.getCnpj())
        .address(restaurante.getAddress())
        .typePCD(restaurante.getTypePCD())
        .menu(encodedMenu)
        .profilePicture(encodedProfilePicture)
        .classification(restaurante.getClassification())
        .clienteId(restaurante.getClienteId())
        .build();
    }
}
