package org.github.kodido.hcp.provisioning.api;


import org.github.kodido.hcp.provisioning.model.Database;
import org.github.kodido.hcp.provisioning.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/databases")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @RequestMapping( method = RequestMethod.GET, produces = { "application/json" } )
    public Mono<Resources<Resource<Database>>> getDatabases(){
        return databaseService.getDatabases()
                .log()
                .map(db -> new Resource<>(db))
                .collectList()
                .map(Resources::new);
    }

}
