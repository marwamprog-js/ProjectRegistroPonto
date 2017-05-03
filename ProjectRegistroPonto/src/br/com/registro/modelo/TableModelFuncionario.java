/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.registro.modelo;

import br.com.registro.entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * .
 * @Eduardo
 */
public class TableModelFuncionario {

    private final String[] NOME_COLUNA = {"idFuncionario", "nome", "cargo",
        "setor", "telefoneCelular", "rua", "numero", "bairro", "cidade", "descicao", "usuario", "senha", "data"};
    private List<Funcionario> listaFuncionario;

    public TableModelFuncionario() {
        listaFuncionario = new ArrayList<>();
        adicionaTodosFuncionarios();
    }

    public int getRowCount() {
        return listaFuncionario.size();
    }

    public void adicionaTodosFuncionarios() {
        FuncionarioDAO dao = new FuncionarioDAO();
        for (Funcionario func : dao.listaFuncionario()) {
            listaFuncionario.add(func);
        }

    }

    public int getColumnCount() {
        return NOME_COLUNA.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaFuncionario.get(rowIndex).getIdFuncionario();
            case 1:
                return this.listaFuncionario.get(rowIndex).getBairro();
            case 2:
                return this.listaFuncionario.get(rowIndex).getCargo();
            case 3:
                return this.listaFuncionario.get(rowIndex).getCidade();
            case 4:
                return this.listaFuncionario.get(rowIndex).getRua();
            case 5:
                return this.listaFuncionario.get(rowIndex).getNome();
            case 6:
                return this.listaFuncionario.get(rowIndex).getData();
            case 7:
                return this.listaFuncionario.get(rowIndex).getTelefoneCelular();
            default:
                return this.listaFuncionario.get(rowIndex);

        }
    }

    public String getColumnName(int indiceColumn) {
        return NOME_COLUNA[indiceColumn];
    }
}
