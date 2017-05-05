/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.registro.modelo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TECNICO
 */
public class RelatorioDAO {

    public void geraRelatorio(Long idFuncionario) {

        //Pesquise o que é HashMap
        HashMap filtro = new HashMap();  //Pesquise o que é HashMap    
        filtro.put("idFuncionario", idFuncionario);
        

        try {

            //Pegando o relatorio e convertendo em conjunto de bits (Pega relatorio) --> Caminho do arquivo
            InputStream inputStream = getClass().getResourceAsStream("/Relatorios/Relatório.jasper");

            JasperReport relatorio;

            relatorio = (JasperReport) JRLoader.loadObject(inputStream); //Passando os bits pegado do inputStream para Exibir do tipo JasperReport

            //---------- Desenhando o relatorio --------- // 
            JasperPrint print = JasperFillManager.fillReport(relatorio, filtro, getConexao());
           
            //Cria uma janela para exibir o relatorio
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConexao() throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/fazenda", "root", "admin");

        } catch (SQLException ex) {
           
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
