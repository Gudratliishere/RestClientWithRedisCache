package com.company.clientappwithredis.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseDTO implements Serializable
{
    private String successMessage;
    private String errorMessage;
    private Integer errorCode;
    private Object object;

    public static ResponseDTO of (Object object, String successMessage)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        responseDTO.setSuccessMessage(successMessage);
        return responseDTO;
    }

    public static ResponseDTO of (Object object, String errorMessage, Integer errorCode)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        responseDTO.setErrorMessage(errorMessage);
        responseDTO.setErrorCode(errorCode);
        return responseDTO;
    }
}
