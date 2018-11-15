/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.acciones.bean.impl;

import edu.eci.arsw.acciones.model.HttpConnection;
import edu.eci.arsw.acciones.bean.Acciones;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan Prieto
 */
@Service("Iex")
public class AccionesIex implements Acciones {

    @Override
    public String obtenerAcciones(String rango, String nombreAccion) throws IOException {
        return HttpConnection.getUrlData("https://api.iextrading.com/1.0/stock/" + nombreAccion + "/chart/" + rango);
    }

    @Override
    public String buscarNombresAcciones(String keyWords) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
