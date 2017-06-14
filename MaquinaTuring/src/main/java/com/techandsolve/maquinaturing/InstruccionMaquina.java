/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techandsolve.maquinaturing;

/**
 *
 * @author daniel.bustamante
 */
public class InstruccionMaquina {
    
    private final Estado estadoActual;
    private final Simbolo simboloLeido;
    
    private final Estado estadoFinal;
    private final Simbolo simboloEscribir;
    private final Direccion direccion;

    public InstruccionMaquina(Estado estadoActual, Simbolo simboloLeido, Estado estadoFinal, Simbolo simboloEscribir, Direccion direccion) {
        this.estadoActual = estadoActual;
        this.simboloLeido = simboloLeido;
        this.estadoFinal = estadoFinal;
        this.simboloEscribir = simboloEscribir;
        this.direccion = direccion;
    }
    
    public static InstruccionMaquina Inst(Estado estadoActual, Simbolo simboloLeido, Estado estadoFinal, Simbolo simboloEscribir, Direccion direccion) {
        return new InstruccionMaquina(estadoActual, simboloLeido, estadoFinal, simboloEscribir, direccion);
    }
    
    public boolean matches(Estado estado, Simbolo simbolo){
        return estadoActual.equals(estado) && simboloLeido == simbolo;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public Simbolo getSimboloLeido() {
        return simboloLeido;
    }

    public Estado getEstadoFinal() {
        return estadoFinal;
    }

    public Simbolo getSimboloEscribir() {
        return simboloEscribir;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
    

    public interface Estado {}
    public interface Simbolo {}
    
    public enum Direccion{IZQ, DER, STY}
    
}
