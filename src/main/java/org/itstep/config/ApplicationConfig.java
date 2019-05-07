package org.itstep.config;

import org.itstep.dao.UserDAO;
import org.itstep.dao.connection.ConnectionFactory;
import org.itstep.dao.connection.H2Factory;
import org.itstep.dao.connection.PostgresFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean()
    @Qualifier("connectionFactory")
    public ConnectionFactory getConnectionFactory(){
        return new H2Factory();
//        return new PostgresFactory();
    }

    @Bean
    @Qualifier("userDAO")
    public UserDAO getUserDAO(@Qualifier("connectionFactory") ConnectionFactory connectionFactory){
        UserDAO userDAO = new UserDAO();
        userDAO.setConnectionFactory(connectionFactory);
        return userDAO;
    }

}
