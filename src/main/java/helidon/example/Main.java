/**
 * Copyright 2018 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package helidon.example;

import io.helidon.config.Config;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.json.JsonSupport;

import java.util.logging.LogManager;

public class Main {

    public static void main(String... args) throws Exception {
        // Load logging.properties
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));

        // Load application.yaml from the classpath
        Config config = Config.create();

        // Create server configuration from application.yaml
        ServerConfiguration serverConfig = ServerConfiguration.fromConfig(config.get("server"));

        // Define server routing rules
        Routing routingConfig = Routing.builder()
                .register(JsonSupport.get())
                .register("/hello", new HelloService())
                .build();

        // Create server
        WebServer server = WebServer.create(serverConfig, routingConfig);

        // Start the server
        server.start().thenAccept(ws -> System.out.println("Server running: http://localhost:" + ws.port()));

        // Server shutdown hook
        server.whenShutdown().thenRun(() -> System.out.println("Server shutdown"));
    }
}
