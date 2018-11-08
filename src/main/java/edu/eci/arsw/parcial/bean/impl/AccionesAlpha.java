/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.bean.impl;

import edu.eci.arsw.parcial.Model.HttpConnection;
import edu.eci.arsw.parcial.bean.Acciones;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan Prieto
 */
@Service("Alpha")
public class AccionesAlpha implements Acciones {

    private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<String, String>();
    private ConcurrentHashMap<String, String> contenido = new ConcurrentHashMap<String, String>();

    @Override
    public String obtenerAcciones(String rango, String nameAccion) throws IOException {
        String urlData;
        if (cache.containsKey(rango) && cache.containsValue(nameAccion)) {
            System.out.println("Lo tiene");
            urlData = contenido.get(rango + nameAccion);
        } else {
            System.out.println("No lo tiene");
            urlData = HttpConnection.getUrlData("https://www.alphavantage.co/query?function=" + rango + "&symbol=" + nameAccion + "&interval=5min&apikey=Q1QZFVJQ21K7C6XM");
            cache.put(rango, nameAccion);
            contenido.put(rango + nameAccion, urlData);
        }
        return urlData;
    }

}
