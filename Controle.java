/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.entidade;

import java.sql.Time;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author TECNICO
 */
public class Controle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idControle;
    private Time horaEntrada;
    private Time horaAlmoco;
    private Time horaRetornoAlmoco;
    private Date data;
    private String status;

    public Long getIdControle() {
        return idControle;
    }

    public void setIdControle(Long idControle) {
        this.idControle = idControle;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraAlmoco() {
        return horaAlmoco;
    }

    public void setHoraAlmoco(Time horaAlmoco) {
        this.horaAlmoco = horaAlmoco;
    }

    public Time getHoraRetornoAlmoco() {
        return horaRetornoAlmoco;
    }

    public void setHoraRetornoAlmoco(Time horaRetornoAlmoco) {
        this.horaRetornoAlmoco = horaRetornoAlmoco;
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
    
    //gfdhdfghdfghdfhdf
    
}
