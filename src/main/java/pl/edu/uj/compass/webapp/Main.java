package pl.edu.uj.compass.webapp;

import org.apache.log4j.Logger;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by shybovycha on 05/05/16.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("WEBAPP");

        TemplateEngine templateEngine = new MustacheTemplateEngine();
        Map<String, String> bindings = new HashMap<>();

        // hello.mustache file is in resources/templates directory
        get("/", (req, res) -> {
            bindings.put("name", "World");

            return new ModelAndView(bindings, "hello.mustache");
        }, templateEngine);

        get("/:name", (req, res) -> {
            bindings.put("name", req.params("name"));

            return new ModelAndView(bindings, "hello.mustache");
        }, templateEngine);

        logger.info("Server is up and running");
    }
}
