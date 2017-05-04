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
   private Date horaEntrada;
   private Date horaAlmoco;
   private Date horaRetornoAlmoco;
   private Date horaSaida;
   private Date horaExtra;
   private Date data;
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

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraAlmoco() {
        return horaAlmoco;
    }

    public void setHoraAlmoco(Date horaAlmoco) {
        this.horaAlmoco = horaAlmoco;
    }

    public Date getHoraRetornoAlmoco() {
        return horaRetornoAlmoco;
    }

    public void setHoraRetornoAlmoco(Date horaRetornoAlmoco) {
        this.horaRetornoAlmoco = horaRetornoAlmoco;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(Date horaExtra) {
        this.horaExtra = horaExtra;
    }

    
   
      
    
    
    
}
