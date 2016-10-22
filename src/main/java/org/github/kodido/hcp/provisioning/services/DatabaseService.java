package org.github.kodido.hcp.provisioning.services;

import org.github.kodido.hcp.provisioning.model.Database;
import reactor.core.publisher.Flux;

/**
 * Created by i031908 on 21/10/16.
 */
public interface DatabaseService {

    Flux<Database> getDatabases();

}
