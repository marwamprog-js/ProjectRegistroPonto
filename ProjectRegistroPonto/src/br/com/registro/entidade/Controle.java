/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.registro.entidade;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author JORDAN - PC
 */

@Entity
public class Controle {


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long idControle;
   private String horaEntrada;
   private String horaAlmoco;
   private String horaRetornoAlmoco;
   private String horaSaida;
   private String horaExtra;
   private String data;
   private String descricao;
   private String status;
   
   @ManyToOne(targetEntity = Funcionario.class)
   private Funcionario funcionario;

    public Long getIdControle() {
        return idControle;
    }

    public void setIdControle(Long idControle) {
        this.idControle = idControle;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraAlmoco() {
        return horaAlmoco;
    }

    public void setHoraAlmoco(String horaAlmoco) {
        this.horaAlmoco = horaAlmoco;
    }

    public String getHoraRetornoAlmoco() {
        return horaRetornoAlmoco;
    }

    public void setHoraRetornoAlmoco(String horaRetornoAlmoco) {
        this.horaRetornoAlmoco = horaRetornoAlmoco;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(String horaExtra) {
        this.horaExtra = horaExtra;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

     
    
    
}
