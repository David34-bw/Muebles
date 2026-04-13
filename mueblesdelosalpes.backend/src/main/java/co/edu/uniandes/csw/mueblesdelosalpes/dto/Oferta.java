/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniandes.csw.mueblesdelosalpes.dto;

/**
 *
 * @author PC
 */
public class Oferta {

    private long id;
    private long referenciaMueble;
    private double descuento;

    public Oferta(){}

    public Oferta(long id, long referenciaMueble, double descuento) {
        this.id = id;
        this.referenciaMueble = referenciaMueble;
        this.descuento = descuento;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getReferenciaMueble() { return referenciaMueble; }
    public void setReferenciaMueble(long referenciaMueble) {
        this.referenciaMueble = referenciaMueble;
    }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}