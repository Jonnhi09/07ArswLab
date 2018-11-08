/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.bean.impl;

import edu.eci.arsw.parcial.Model.HttpConnection;
import edu.eci.arsw.parcial.bean.Acciones;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonnhi
 */
@Service("Iex")
public class AccionesIex implements Acciones {

    @Override
    public String obtenerAcciones(String rango, String nameAccion) throws IOException {
        return HttpConnection.getUrlData("https://api.iextrading.com/1.0/stock/" + nameAccion + "/chart/" + rango);
    }

}
