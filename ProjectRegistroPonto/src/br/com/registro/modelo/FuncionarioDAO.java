
package br.com.registro.modelo;

import br.com.registro.entidade.Funcionario;
import br.com.registro.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *. @author Eduardo
 */
public class FuncionarioDAO {
    Session session;
    
    public boolean salvar (Funcionario funcionario){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(funcionario);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null, "Erro de coexão"+ e);
            return false;
        }finally{
            session.close();
        }
    }
    public boolean excluirFuncionario(Funcionario funcionario){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(funcionario);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            JOptionPane.showMessageDialog(null,"Erro de conexão"+ e);
            return false;
        }finally{
            session.close();
        }
    }
    public boolean updateFunconario(Funcionario funcionario){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(funcionario);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            session.close();
        }
    }
    public List<Funcionario> listaFuncionario(){
        
        List<Funcionario>listaFuncionario = new ArrayList<>();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criterio = session.createCriteria(Funcionario.class);
        criterio.addOrder(Order.asc("nome"));
        listaFuncionario = criterio.list();
        return  listaFuncionario;
    }
    
    public List<Funcionario> pesquisaPorCodigoFuncionario(Long codigo){
        List<Funcionario> listaFuncionarioCodigo = new ArrayList<>();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criterio = session.createCriteria(Funcionario.class);
        criterio.add(Restrictions.idEq(codigo));
        listaFuncionarioCodigo = criterio.list();
        return listaFuncionarioCodigo;
    }
     
        public List<Funcionario> identificaUsuario(String login,String senha){
         
         List<Funcionario> listaFuncionario = new ArrayList<>();
         
         session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         
         Criteria crit = session.createCriteria(Funcionario.class);
         crit.add(Restrictions.like("usuario", login));
         crit.add(Restrictions.like("senha",senha)); 
        
         listaFuncionario = crit.list();
         
         return listaFuncionario;
     }
  
        
}
