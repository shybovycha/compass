package pl.edu.uj.compass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.uj.compass.entities.Org;
import pl.edu.uj.compass.repositories.OrgRepository;

import java.util.List;

@EnableJpaRepositories("pl.edu.uj.compass.repositories")
@EntityScan("pl.edu.uj.compass.entities")
@ComponentScan(basePackages = { "pl.edu.uj.compass.matcher", "pl.edu.uj.compass.controllers" })
@RestController
@RequestMapping("/orgs")
public class OrgController {
    @Autowired
    protected OrgRepository orgRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<Org> all() {
        return (List<Org>) orgRepository.findAll();
    }
}
