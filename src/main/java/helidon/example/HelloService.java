package helidon.example;

import io.helidon.webserver.Handler;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

import javax.json.Json;
import javax.json.JsonObject;

public class HelloService implements Service {

    @Override
    public void update(Routing.Rules rules) {
        rules.get(this::defaultHandler);
    }

    private void defaultHandler(final ServerRequest request, final ServerResponse response) {
        JsonObject returnObject = Json.createObjectBuilder()
                .add("message", "Hello, World!")
                .build();

        response.send(returnObject);
    }
}
