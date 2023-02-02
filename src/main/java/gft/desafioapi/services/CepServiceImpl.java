package gft.desafioapi.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import gft.desafioapi.entities.CepResponse;

@Service
@Transactional
public class CepServiceImpl implements CepService {
    @Override
    public CepResponse buscaCep(String cep) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String URLAPI = "https://viacep.com.br/ws/"+cep+"/json/";
		CepResponse response = restTemplate.getForObject(URLAPI, CepResponse.class);
        return response;
    }
    
}
