/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.service;

import edu.eci.arsw.parcial.bean.Acciones;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan Prieto
 */
@Service
public class AccionesServicesImpl implements AccionesServices {

    @Autowired
    @Qualifier("Alpha")
    Acciones acciones;

    @Override
    public String obtenerAcciones(String rango, String nameAccion) throws IOException {
        return acciones.obtenerAcciones(rango, nameAccion);
    }
}
