package org.itstep.dao;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.itstep.dao.connection.ConnectionFactory;
import org.itstep.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Setter
@Getter
//@Component
@Repository
@Qualifier("userDAO")
public class UserDAO{

    @Autowired
//    @Qualifier("h2Factory")
	private ConnectionFactory connectionFactory;
	
	public void saveOrUpdate(User user){
		Session session = connectionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();		
	}
	
	public User findOne(Integer id){
		Session session = connectionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        User userFromDB = (User)session.find(User.class, id);
        session.getTransaction().commit();
        session.close();
        return userFromDB;
	}

	public List<User> findAll(){
		Session session = connectionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        String sql = "SELECT * FROM users";
              
        List<User> result = session.createNativeQuery(sql).getResultList();
        
        session.close();
        return result;
	}
	
	public void delete(User user) {
		Session session = connectionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
	}
	
}
