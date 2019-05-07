package org.itstep.dao.connection;

import org.hibernate.SessionFactory;

public interface ConnectionFactory {

    SessionFactory getSessionFactory();
}
