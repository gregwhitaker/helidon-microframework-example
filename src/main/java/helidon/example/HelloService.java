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

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

import javax.json.Json;
import javax.json.JsonObject;

public class HelloService implements Service {

    @Override
    public void update(Routing.Rules rules) {
        rules.get("/", this::defaultHandler);
        rules.get("/{name}", this::nameHandler);
    }

    private void defaultHandler(final ServerRequest request, final ServerResponse response) {
        JsonObject rsp = Json.createObjectBuilder()
                .add("message", "Hello, World!")
                .build();

        response.send(rsp);
    }

    private void nameHandler(final ServerRequest request, final ServerResponse response) {
        String name = request.path().param("name");
        String msg = String.format("Hello, %s!", name);

        JsonObject rsp = Json.createObjectBuilder()
                .add("message", msg)
                .build();

        response.send(rsp);
    }
}
