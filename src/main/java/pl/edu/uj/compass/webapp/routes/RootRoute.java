package pl.edu.uj.compass.webapp.routes;

import pl.edu.uj.compass.webapp.AbstractRoute;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by shybovycha on 05/05/16.
 */
public class RootRoute extends AbstractRoute {
    public RootRoute() {}

    @Override
    public void init() {
        TemplateEngine templateEngine = new MustacheTemplateEngine();
        Map<String, Object> bindings = new HashMap<>();

        // hello.mustache file is in resources/templates directory
        get("/", (req, res) -> {
            bindings.put("name", "World");

            return new ModelAndView(bindings, "hello.mustache");
        }, templateEngine);

        get("/hello/:name", (req, res) -> {
            bindings.put("name", req.params("name"));

            return new ModelAndView(bindings, "hello.mustache");
        }, templateEngine);
    }
}
