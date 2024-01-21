import lombok.extern.slf4j.Slf4j;
import org.mockserver.integration.ClientAndServer;

import java.io.IOException;

import static org.mockserver.model.HttpRequest.request;

@Slf4j
public class Server {

    void start() throws IOException {
        try(ClientAndServer mockServer = new ClientAndServer(100);){
            mockServer.when(request().withPath("/test_path")).respond(new ServiceResponse());
                    //.respond(org.mockserver.model.HttpResponse.response().withBody("{ \"key\": \"value\" }"));
            log.info("server started");
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }
}
