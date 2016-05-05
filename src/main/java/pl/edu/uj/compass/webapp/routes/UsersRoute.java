package pl.edu.uj.compass.webapp.routes;

import org.apache.ibatis.session.SqlSession;
import pl.edu.uj.compass.webapp.AbstractRoute;
import pl.edu.uj.compass.webapp.DatabaseAdapter;
import pl.edu.uj.compass.webapp.models.User;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by shybovycha on 06/05/16.
 */
public class UsersRoute extends AbstractRoute {
    public UsersRoute() {}

    @Override
    public void init() {
        TemplateEngine templateEngine = new MustacheTemplateEngine();
        Map<String, Object> bindings = new HashMap<>();

        get("/users", (req, res) -> {
            List<User> users = new ArrayList<>();

            try (SqlSession sqlSession = DatabaseAdapter.getIntance().getSqlSessionFactory().openSession()) {
                users = sqlSession.selectList("Users.all");
            } catch (Exception e) {
                e.printStackTrace();
            }

            bindings.put("users", users);

            return new ModelAndView(bindings, "users.mustache");
        }, templateEngine);
    }
}
