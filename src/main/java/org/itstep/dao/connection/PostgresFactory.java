package org.itstep.dao.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.itstep.entity.Cart;
import org.itstep.entity.Item;
import org.itstep.entity.Order;
import org.itstep.entity.User;

import java.util.Properties;

public class PostgresFactory implements ConnectionFactory {

    public SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            Properties properties = new Properties();

            properties.setProperty("hibernate.connection.driverClassName", "org.postgresql.Driver");
            properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/e-store");
            properties.setProperty("hibernate.connection.username", "postgres");
            properties.setProperty("hibernate.connection.password", "248842");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            properties.setProperty("hibernate.hbm2ddl.auto", "update");
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.format_sql", "true");

            configuration.addProperties(properties);

            configuration.addAnnotatedClass(Item.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(Cart.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
