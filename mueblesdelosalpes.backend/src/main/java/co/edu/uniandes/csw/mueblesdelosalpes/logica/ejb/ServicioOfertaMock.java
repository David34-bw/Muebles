/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
@Stateless
public class ServicioOfertaMock implements IServicioOfertaMockLocal{

    private List<Oferta> ofertas = new ArrayList<>();

    @Override
    public void agregarOferta(Oferta oferta) {
        ofertas.add(oferta);
    }

    @Override
    public List<Oferta> getOfertas() {
        return ofertas;
    }

}