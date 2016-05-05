package pl.edu.uj.compass.webapp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shybovycha on 05/05/16.
 */
public class DatabaseAdapter {
    private SqlSessionFactory sqlSessionFactory = null;
    private static DatabaseAdapter instance = null;

    public static void createInstance() {
        if (instance == null) {
            instance = new DatabaseAdapter();
            instance.init();
        }
    }

    public static DatabaseAdapter getIntance() {
        createInstance();

        return instance;
    }

    public DatabaseAdapter() {}

    protected void init() {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
