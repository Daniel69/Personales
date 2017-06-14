/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techandsolve.maquinaturing;

import java.util.Arrays;
import static com.techandsolve.maquinaturing.InstruccionMaquina.*;
import java.util.List;

/**
 *
 * @author daniel.bustamante
 */
public class PruebaMaquina {
    public static void main(String[] args) {
        
        List<InstruccionMaquina> code = Arrays.asList(
                Inst(Est.A, null,       Est.B,      Symb.S1, Direccion.DER),
                Inst(Est.A, Symb.S1,    Est.C,      Symb.S1, Direccion.IZQ),
                Inst(Est.B, null,       Est.A,      Symb.S1, Direccion.IZQ),
                Inst(Est.B, Symb.S1,    Est.B,      Symb.S1, Direccion.DER),
                Inst(Est.C, null,       Est.B,      Symb.S1, Direccion.IZQ),
                Inst(Est.C, Symb.S1,    Est.END,    Symb.S1, Direccion.STY)     
        );
        
        MaquinaTuringUniversal maquinaTuring = new MaquinaTuringUniversal(Est.A, Est.END, code);
        List<Simbolo> entrada = Arrays.asList();
        List<Simbolo> salida = maquinaTuring.ejecuarMaquina(entrada);
        
        salida.forEach(System.out::println);
        
    }
}

/**
 * Three-state busy beaver

States: a, b, c, halt
Initial state: a
Terminating states: halt
Permissible symbols: 0, 1
Blank symbol: 0
Rules:
(a, 0, 1, right, b)
(a, 1, 1, left, c)
(b, 0, 1, left, a)
(b, 1, 1, right, b)
(c, 0, 1, left, b)
(c, 1, 1, stay, halt)

The input for this machine should be an empty tape.
 * @author daniel.bustamante
 */



enum Symb implements InstruccionMaquina.Simbolo{
    S1
}

enum Est implements InstruccionMaquina.Estado{
    A,B,C, END
}