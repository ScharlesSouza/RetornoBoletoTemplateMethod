/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.retornoboletostrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeituraRetornoBancoBrasil extends LeituraRetornoBancos {


        
    @Override
    Boleto montarBoleto(String linha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
         String[] textoSeparado = linha.split(";");
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(textoSeparado[0]));
        boleto.setCodBanco(textoSeparado[1]);
        
        try {
                 boleto.setDataVencimento(sdf.parse(textoSeparado[2]));
                boleto.setDataPagamento(sdf.parse(textoSeparado[3]));    
        } catch (ParseException ex) {
            Logger.getLogger(LeituraRetornoBancoBrasil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boleto.setCpfcliente(textoSeparado[4]);                
        boleto.setValor(Double.parseDouble(textoSeparado[5]));
        boleto.setMulta(Double.parseDouble(textoSeparado[6]));
        boleto.setJuros(Double.parseDouble(textoSeparado[7]));
        return boleto;
         
    }


}
