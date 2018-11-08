/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.controller;

import edu.eci.arsw.parcial.service.AccionesServices;
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

    @RequestMapping(method = RequestMethod.GET, path = "/{rango}/{nombreAccion}")
    public ResponseEntity<?> getAcciones(@PathVariable("rango") String rango, @PathVariable("nombreAccion") String nombreAccion) {
        try {
            return new ResponseEntity<>(as.obtenerAcciones(rango, nombreAccion), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las acciones del nombre y rango dado.", HttpStatus.NOT_FOUND);
        }
    }
}
