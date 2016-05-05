package pl.edu.uj.compass.webapp;

import pl.edu.uj.compass.webapp.routes.RootRoute;
import pl.edu.uj.compass.webapp.routes.UsersRoute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shybovycha on 05/05/16.
 */
public class Application {
    public Application() {}

    public void run() {
        initDatabase();
        initControllers();
    }

    private void initDatabase() {
        DatabaseAdapter.createInstance();
    }

    private void initControllers() {
        List<AbstractRoute> routes = new ArrayList<>();

        routes.add(new RootRoute());
        routes.add(new UsersRoute());

        routes.forEach(AbstractRoute::init);
    }
}
