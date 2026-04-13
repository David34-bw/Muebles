/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IServicioOfertaMockLocal {

    public void agregarOferta(Oferta oferta);

    public List<Oferta> getOfertas();

}