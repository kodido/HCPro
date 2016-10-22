package org.github.kodido.hcp.provisioning.services.impl;

import org.github.kodido.hcp.provisioning.model.Database;
import org.github.kodido.hcp.provisioning.services.DatabaseService;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.reactive.ClientWebRequestBuilders;
import org.springframework.web.client.reactive.ResponseExtractors;
import org.springframework.web.client.reactive.WebClient;
import reactor.core.publisher.Flux;


@Service
public class DatabaseServiceImpl implements DatabaseService {

    private static final String SERVICE_URL =
            "https://services.neo.ondemand.com/services/v1/instances/xd6ada5d1/persistence/v1/dbms";
    WebClient client = new WebClient(new ReactorClientHttpConnector());

    @Override
    public Flux<Database> getDatabases() {
        client
                .perform(ClientWebRequestBuilders.get(SERVICE_URL).accept(MediaType.APPLICATION_JSON))
                .extract(ResponseExtractors.body(Database.class));
        return mockDatabase();
    }

    private Flux<Database> mockDatabase() {
        Database result = new Database();
        result.setType("oracle");
        result.setVersion("12.24");
        result.setName("MyDB");
        return Flux.just(result);
    }
}
