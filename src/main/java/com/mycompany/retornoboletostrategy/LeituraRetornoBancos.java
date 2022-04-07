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


public abstract class LeituraRetornoBancos implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(String caminhoArquivo) {
        List<Boleto> listaBoletos = new ArrayList<>();
        String linha;
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
            while(leitor.ready()){
                linha = leitor.readLine();
                listaBoletos.add(montarBoleto(linha));
            }
            leitor.close();
            return listaBoletos;
        } catch (IOException ex) {
            Logger.getLogger(LeituraRetornoBancoBrasil.class.getName()).log(Level.SEVERE, null, ex);
       }
        return listaBoletos;
    }
    
                    
    abstract Boleto montarBoleto(String linha);
}
