package com.ufps.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseUtil {

    public static ResponseEntity<Map<String, Object>> buildErrorResponse(Exception e) {
    	
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", true);
        errorResponse.put("msg", e.getMessage());

        HttpStatus status;
        switch (e.getMessage()) {
            case "Usuario no encontrado":
                status = HttpStatus.NOT_FOUND;
                break;
            case "Manga no encontrado":
                status = HttpStatus.NOT_FOUND;
                break;
            case "Favorito no encontrado":
                status = HttpStatus.NOT_FOUND;
                break;
            case "Pais no existe":
                status = HttpStatus.BAD_REQUEST;
                break;
            case "Tipo no existe":
                status = HttpStatus.BAD_REQUEST;
                break;
            case "Manga tiene usuarios asociados":
                status = HttpStatus.CONFLICT;
                break;
            case "Favorito ya se encuentra registrado":
                status = HttpStatus.CONFLICT;
                break;
            default:
                // Maneja errores de campos obligatorios faltantes
                if (e.getMessage().startsWith("El campo")) {
                    status = HttpStatus.BAD_REQUEST;
                } else {
                    // Para cualquier otro tipo de error no especificado
                    status = HttpStatus.INTERNAL_SERVER_ERROR;
                }
                break;
        }

        return ResponseEntity.status(status).body(errorResponse);
    }
}
