/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.service;

import java.io.IOException;

/**
 *
 * @author jonnhi
 */
public interface AccionesServices {

    public String obtenerAcciones(String rango, String nameAccion) throws IOException;
}
