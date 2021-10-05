package com.company.clientappwithredis.controller;

import com.company.clientappwithredis.dto.PetDTO;
import com.company.clientappwithredis.dto.ResponseDTO;
import com.company.clientappwithredis.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PetController
{

    private final PetService petService;

    @GetMapping("/pet")
    public ResponseDTO getPets ()
    {
        return petService.getPets();
    }

    @PostMapping("/pet")
    public ResponseDTO addPet (
            @RequestBody PetDTO petDTO
                                              )
    {
        petService.clearGetPetsCache();
        return petService.addPets(petDTO);
    }
}
