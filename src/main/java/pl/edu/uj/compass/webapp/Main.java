package pl.edu.uj.compass.webapp;

import org.apache.log4j.Logger;

/**
 * Created by shybovycha on 05/05/16.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("WEBAPP");

        Application app = new Application();

        app.run();

        logger.info("Server is up and running");
    }
}
