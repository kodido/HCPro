package org.github.kodido.hcp.provisioning.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( {
        "org.github.kodido.hcp.provisioning.api",
        "org.github.kodido.hcp.provisioning.services.impl"
} )
public class AppConfig {
}
