/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.acciones.service;

import java.io.IOException;

/**
 *
 * @author Jonathan Prieto
 */
public interface AccionesServices {

    /**
     *
     * @param rango
     * @param nombreAccion
     * @return
     * @throws IOException
     */
    public String obtenerAcciones(String rango, String nombreAccion) throws IOException;

    /**
     *
     * @param keyWords
     * @return
     * @throws IOException
     */
    public String buscarNombresAcciones(String keyWords) throws IOException;
}
