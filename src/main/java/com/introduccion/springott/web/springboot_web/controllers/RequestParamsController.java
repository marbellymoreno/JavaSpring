package com.introduccion.springott.web.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.introduccion.springott.web.springboot_web.controllers.models.DTO.ParamDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @Value("${config.mensaje}")
    private String mensaje;

    @Value("#{'${config.direccion}'.toUpperCase()}")
    private String direccion;

    @Value("${config.edad}")
    private int edad;

    @Value("${config.saludo}")
    private String saludo;

    @Value("#{${config.mapa}}")
    private Map<String, Object> mapa;

    @Autowired
    private Environment env;

    @GetMapping("/foot")
    public ParamDTO foot(@RequestParam(required = false, defaultValue = "Sin mensaje") String mensaje) {
        ParamDTO param = new ParamDTO(mensaje);
        return param;
    }

    @GetMapping("/muchos")
    public ParamDTO muchos(
            @RequestParam(name = "m", defaultValue = "ningun mensaje") String mensaje,
            @RequestParam(name = "d", defaultValue = "ninguna direccion") String direccion) {
        return new ParamDTO(mensaje, direccion);
    }

    @GetMapping("/servlet")
    public ParamDTO getFromServlet(HttpServletRequest request) {
        return new ParamDTO(
                request.getParameter("mensaje"),
                request.getParameter("direccion"));
    }

    @GetMapping("/try")
    public ParamDTO errores(HttpServletRequest request) {
        try {
            int edad = request.getParameter("edad") != null
                    ? Integer.parseInt(request.getParameter("edad"))
                    : 0;
            return new ParamDTO(
                    request.getParameter("mensaje"),
                    request.getParameter("direccion"),
                    edad);
        } catch (NumberFormatException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @GetMapping("/ejemplo/{variable}")
    public ParamDTO ejemplo(@PathVariable String variable) {
        ParamDTO param = new ParamDTO();
        param.setMensaje(variable);
        return param;
    }

    @GetMapping("/ejemplo/{variable}/{variable2}")
    public ParamDTO ejemplo2(
            @PathVariable String variable,
            @PathVariable String variable2) {
        ParamDTO param = new ParamDTO();
        param.setMensaje(variable);
        param.setDireccion(variable2);
        return param;
    }

    @PostMapping("/usopost")
    public ParamDTO usoRequest(@RequestBody ParamDTO user) {
        user.setMensaje(user.getMensaje().toUpperCase());
        user.setDireccion(user.getDireccion().toUpperCase());
        user.setEdad(user.getEdad() + 1);
        return user;
    }

    @GetMapping("/inyectar")
    public Map<String, Object> inyectar(@Value("${config.Arr}") String[] lista) {
        Map<String, Object> json = new HashMap<>();
        json.put("mensaje", mensaje);
        json.put("direccion", direccion);
        json.put("edad", edad);
        json.put("lista", lista);
        json.put("saludo", saludo);
        json.put("mapa", mapa);

        String map2 = env.getProperty("config.y");

        if (map2 != null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> jsonMap = mapper.readValue(map2, new TypeReference<Map<String, Object>>() {});
                json.put("env", jsonMap);
            } catch (JsonProcessingException e) {
                json.put("env", "Error al procesar JSON: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            json.put("env", "config.y no está definido");
        }

        return json;
    }
}
