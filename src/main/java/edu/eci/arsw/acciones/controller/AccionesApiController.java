/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.acciones.controller;

import edu.eci.arsw.acciones.service.AccionesServices;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonathan Prieto
 */
@RestController
@RequestMapping("/acciones")
public class AccionesApiController {

    @Autowired
    private AccionesServices as;

    /**
     *
     * @param rango
     * @param nombreAccion
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{rango}/{nombreAccion}")
    public ResponseEntity<?> getAcciones(@PathVariable("rango") String rango, @PathVariable("nombreAccion") String nombreAccion) {
        try {
            return new ResponseEntity<>(as.obtenerAcciones(rango.toLowerCase(), nombreAccion.toLowerCase()), HttpStatus.ACCEPTED);
        } catch (IOException e) {
            return new ResponseEntity<>("Error al obtener las acciones del nombre y rango dado.", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/search/{keyWords}")
    public ResponseEntity<?> buscarAcciones(@PathVariable("keyWords") String keyWords) {
        try {
            return new ResponseEntity<>(as.buscarNombresAcciones(keyWords.toLowerCase()), HttpStatus.ACCEPTED);
        } catch (IOException e) {
            return new ResponseEntity<>("Error al buscar las acciones con los caracteres dados.", HttpStatus.NOT_FOUND);
        }
    }
}
