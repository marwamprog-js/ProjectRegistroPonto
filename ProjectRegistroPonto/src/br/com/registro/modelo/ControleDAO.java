/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.registro.modelo;

import br.com.registro.entidade.Controle;
import br.com.registro.entidade.Funcionario;
import br.com.registro.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user_mw
 */
public class ControleDAO {

    Session sessao;

    //Metodo para salvar dados do controle
    public boolean savar(Controle controle) {

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(controle);

            sessao.getTransaction().commit();

            return true;

        } catch (HibernateException e) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar.: " + e, "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {

            sessao.close();

        }
    }
    

    //Metodo para excluir dados do controle
    public boolean excluir(Controle controle) {
        try {
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.delete(controle);
            sessao.getTransaction().commit();
            return true;
            
        } catch (HibernateException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao excluir.: " + e, "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
            
        } finally {
            sessao.close();
        }
    }

    
    //Metodo para atualizar dados na tabela
    public boolean update(Controle controle) {
        
        try {
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.update(controle);
            sessao.getTransaction().commit();
            return true;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao atualizar.: " + e, "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
            
        } finally {
            
            sessao.close();
            
        }
    }

    
    //Metodo para listar todos os controles
    public List<Controle> listaControle() {
        
        List<Controle> listaControle = new ArrayList<>();
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria criterio = sessao.createCriteria(Controle.class);
        criterio.addOrder(Order.asc("data"));
        
        listaControle = criterio.list();
        return listaControle;
        
    }

    
    //Metodo para retornar o controle por codigo do funcionario
    public List<Controle> pesquisaPorCodigoFuncionario(Long codigo) {
        
        List<Controle> listaFuncionarioCodigo = new ArrayList<>();
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria criterio = sessao.createCriteria(Controle.class);
        criterio.add(Restrictions.idEq(codigo));
        
        listaFuncionarioCodigo = criterio.list();
        return listaFuncionarioCodigo;
    }
    
    //Metodo para retornar o controle por codigo do funcionario
    public List<Controle> pesquisaPorData(Date data) {
        
        List<Controle> listaFuncionarioCodigo = new ArrayList<>();
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        Criteria criterio = sessao.createCriteria(Controle.class);
        criterio.add(Restrictions.idEq(data));
        
        listaFuncionarioCodigo = criterio.list();
        return listaFuncionarioCodigo;
    }
    
    

}


