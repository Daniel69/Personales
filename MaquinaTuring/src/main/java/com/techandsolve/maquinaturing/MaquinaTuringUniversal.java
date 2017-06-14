/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techandsolve.maquinaturing;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author daniel.bustamante
 */
public class MaquinaTuringUniversal {
    
    private InstruccionMaquina.Estado estado;
    private final InstruccionMaquina.Estado estadoFinal;
    private int posicionCinta = 0;
    private LinkedList<InstruccionMaquina.Simbolo> cinta;
    private final List<InstruccionMaquina> programa;

    public MaquinaTuringUniversal(InstruccionMaquina.Estado estadoInicial, InstruccionMaquina.Estado estadoFinal, List<InstruccionMaquina> programa) {
        this.estado = estadoInicial;
        this.programa = programa;
        this.estadoFinal = estadoFinal;
    }
    
    public List<InstruccionMaquina.Simbolo> ejecuarMaquina(List<InstruccionMaquina.Simbolo> entrada){
        cinta = new LinkedList<>(entrada);
        
        while(estado != estadoFinal){
            InstruccionMaquina.Simbolo actualSymbol = leerCinta();
            Optional<InstruccionMaquina> instruccion = programa.stream().filter(i -> i.matches(estado, actualSymbol)).findFirst();
            if(!instruccion.isPresent()) break;
            InstruccionMaquina inst = instruccion.get();
            cinta.set(posicionCinta, inst.getSimboloEscribir());
            posicionCinta = posicionCinta + (inst.getDireccion() == InstruccionMaquina.Direccion.DER ? 1 : (inst.getDireccion() == InstruccionMaquina.Direccion.IZQ ? -1 : 0));
            estado = inst.getEstadoFinal();
        }
       
        return cinta;
    }
    
    private InstruccionMaquina.Simbolo leerCinta(){
        
        if(cinta.size() < posicionCinta + 1){
            cinta.add(null);
        }
        
        if(posicionCinta == -1){
            cinta.addFirst(null);
            posicionCinta = 0;
        }
        
        return cinta.get(posicionCinta);
    }
            
    
    
    
    
    
    
}
