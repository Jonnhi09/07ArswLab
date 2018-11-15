/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.acciones.service;

import edu.eci.arsw.acciones.bean.Acciones;
import edu.eci.arsw.acciones.model.Accion;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.eci.arsw.acciones.persistence.AccionesRepository;

/**
 *
 * @author Jonathan Prieto
 */
@Service
public class AccionesServicesImpl implements AccionesServices {

    @Autowired
    @Qualifier("Alpha")
    Acciones acciones;

    @Autowired
    AccionesRepository repositorio;

    @Override
    public String obtenerAcciones(String rango, String nombreAccion) throws IOException {
        String respuesta;
        Accion accionCache = repositorio.findByNombre(nombreAccion);
        if (accionCache == null) {
            System.out.println("No tiene la accion!");
            ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>();
            respuesta = acciones.obtenerAcciones(rango, nombreAccion);
            hm.put(rango, respuesta);
            repositorio.save(new Accion(nombreAccion, hm));
        } else if (accionCache.getTimeSeries().containsKey(rango)) {
            System.out.println("Tiene la accion y el rango!");
            respuesta = accionCache.getTimeSeries().get(rango);
        } else {
            System.out.println("Tiene la accion pero no el rango!");
            respuesta = acciones.obtenerAcciones(rango, nombreAccion);
            accionCache.getTimeSeries().put(rango, respuesta);
            repositorio.save(accionCache);
        }
        return respuesta;
    }

    @Override
    public String buscarNombresAcciones(String keyWords) throws IOException {
        return acciones.buscarNombresAcciones(keyWords);
    }
}
