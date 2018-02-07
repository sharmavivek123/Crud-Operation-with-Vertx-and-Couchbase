import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Launcher;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;

public class Paractise extends AbstractVerticle {
    private HttpServer httpServer=null;
    public static void main(String[] args) {
        Launcher.executeCommand("run",Paractise.class.getName());
    }
    public void start(Future<Void> f1){
        httpServer=vertx.createHttpServer();
        httpServer.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest httpServerRequest) {
                httpServerRequest.response().end("hello world");
            }
        });
        httpServer.listen(8181);
    }

}
