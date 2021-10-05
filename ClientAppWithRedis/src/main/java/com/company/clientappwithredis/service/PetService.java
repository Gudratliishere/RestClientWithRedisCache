package com.company.clientappwithredis.service;

import com.company.clientappwithredis.dto.PetDTO;
import com.company.clientappwithredis.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PetService
{

    private final static String webUrl = "http://localhost:8099/pet";

    private final RestTemplate restTemplate;

    @Cacheable(cacheNames = "getPets")
    public ResponseDTO getPets ()
    {
        System.out.println("GET PETS RUNNING");
        ResponseEntity<ResponseDTO> responseEntity = restTemplate.getForEntity(webUrl, ResponseDTO.class);
        return responseEntity.getBody();
    }

    @Cacheable(cacheNames = "addPet")
    public ResponseDTO addPets (PetDTO petDTO)
    {
        System.out.println("ADD PET RUNNING");
        ResponseEntity<ResponseDTO> responseEntity =
                restTemplate.postForEntity(webUrl, petDTO, ResponseDTO.class);
        return responseEntity.getBody();
    }

    @CacheEvict(cacheNames = "getPets")
    public void clearGetPetsCache ()
    {
        System.out.println("GET PETS IS CLEAN");
    }
}
