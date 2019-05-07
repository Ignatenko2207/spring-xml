package org.itstep;

import org.itstep.config.ApplicationConfig;
import org.itstep.dao.UserDAO;
import org.itstep.entity.Profile;
import org.itstep.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class ApplicationRunnerAnnotation
{
    private static final Logger LOG = Logger.getLogger(ApplicationRunnerAnnotation.class.getName());

    public static void main( String[] args )
    {
        try {
            AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext();

            context.register(ApplicationConfig.class);
            context.refresh();

            User admin = new User();
            admin.setEmail("ignatenko2207@gmail.com");
            admin.setFirstName("Alex");
            admin.setLastName("Ignatenko");
            admin.setLogin("ignatenko2207");
            admin.setPassword("12345");
            admin.setProfile(Profile.ADMIN);

            User client = new User();
            client.setEmail("ignatenko2207@gmail.com");
            client.setFirstName("Alex");
            client.setLastName("Ignatenko");
            client.setLogin("ignatenko2207-client");
            client.setPassword("12345");
            client.setProfile(Profile.CLIENT);

            UserDAO userDAO = (UserDAO) context.getBean("userDAO");

            userDAO.saveOrUpdate(admin);
            userDAO.saveOrUpdate(client);

            LOG.info("DB has " + userDAO.findAll().size() + " rows in \"USER\" table");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
