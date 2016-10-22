package org.github.kodido.hcp.provisioning.api;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class RootController {



    @RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" } )
    public Mono<Resource<String>> index(){
        return Mono.just(getIndex());
    }


    public Resource<String> getIndex() {
        Resource<String> result = new Resource<>("API Root");

//        TODO: check why spring hateoas is not working with this
//        Object databases = methodOn(DatabaseController.class).getDatabases();
//        Link databasesLink = linkTo(databases).withRel("databases");
//        result.add(databasesLink);

        result.add(new Link("/databases", "databases"));
        result.add(new Link("/"));

        return result;
    }


}
