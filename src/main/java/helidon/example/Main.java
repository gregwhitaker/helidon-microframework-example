package helidon.example;

import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

public class Main {

    public static void main(String... args) {
        WebServer.create(
                Routing.builder()
                        .get("/hello", (req, res)
                                -> res.send("Hello World!"))
                        .build())
                .start();
    }
}
