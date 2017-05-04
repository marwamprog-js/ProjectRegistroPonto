/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.registro.modelo;

import br.com.registro.entidade.Controle;
import br.com.registro.entidade.Funcionario;
import br.com.registro.modelo.ControleDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user_mw
 */
public class TableModelControle extends AbstractTableModel{
    
    private final String[] NOME_COLUNA_CLIENTE = {"Código", "Hora de Entrada", "Hora de Almoço", "Hora Retorno Almoço", "Hora de saida"
        ,"Status", "Data", "Descrição"};  
    private List<Controle> listaTableControle;
    
    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
    
    
    public TableModelControle(){
        
        listaTableControle = new ArrayList<>();
        adicionaTabelaControle();
        
    }
    
    public TableModelControle(Long func){
        
        listaTableControle = new ArrayList<>();
        adicionaTabelaControlePorCodigo(func);
        
    }
    
    
    public void adicionaTabelaControle(){
        
        ControleDAO dao = new ControleDAO();
        
        for(Controle controle : dao.listaControle()){
            
            listaTableControle.add(controle);
            
        }
        
    }
    
    
    
    public void adicionaTabelaControlePorCodigo(Long func){
        
        ControleDAO dao = new ControleDAO();
        
        for(Controle controle : dao.pesquisaPorCodigoFuncionario(func)){
            
            listaTableControle.add(controle);
            
        }
        
    }
    
    
    
    @Override
    public int getRowCount() {
        return listaTableControle.size();
    }

    @Override
    public int getColumnCount() {
        return NOME_COLUNA_CLIENTE.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            
            
            case 0:
                return this.listaTableControle.get(rowIndex).getFuncionario().getIdFuncionario();
            case 1:
                return hora.format(this.listaTableControle.get(rowIndex).getHoraEntrada());
            case 2:
                return hora.format(this.listaTableControle.get(rowIndex).getHoraAlmoco());
            case 3:
                return hora.format(this.listaTableControle.get(rowIndex).getHoraRetornoAlmoco());
            case 4:
                return hora.format(this.listaTableControle.get(rowIndex).getHoraSaida());
            case 5:
                return this.listaTableControle.get(rowIndex).getStatus();
            case 6:
                return data.format(this.listaTableControle.get(rowIndex).getData());
            case 7:
                return this.listaTableControle.get(rowIndex).getDescricao();
            default:
                return this.listaTableControle.get(rowIndex);
            
            
        }
        
        
    }
    
    @Override
    public String getColumnName(int indiceColumn){
        
        return NOME_COLUNA_CLIENTE[indiceColumn];
        
    }   
}
