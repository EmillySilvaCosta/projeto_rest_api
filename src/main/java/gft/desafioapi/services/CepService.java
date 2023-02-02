package gft.desafioapi.services;

import gft.desafioapi.entities.CepResponse;

public interface CepService {

    public CepResponse buscaCep(String cep) throws Exception;

}
