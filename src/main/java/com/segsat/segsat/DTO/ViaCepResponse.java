package com.segsat.segsat.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ViaCepResponse {
    private String logradouro;
    private String bairro;
    private String estado;
    private String localidade;
}
