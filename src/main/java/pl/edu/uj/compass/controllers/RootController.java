package pl.edu.uj.compass.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl.edu.uj.compass.entities")
@ComponentScan(basePackages = { "pl.edu.uj.compass.matcher", "pl.edu.uj.compass.controllers" })
@Controller
@SpringBootApplication
public class RootController {
    @RequestMapping("/")
    String home() {
        return "home";
    }

    @RequestMapping("/app")
    String clientApp() {
        return "redirect:/client/index.html";
    }

    @RequestMapping("/adm")
    String adminApp() {
        return "redirect:/admin/index.html";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RootController.class, args);
    }
}
