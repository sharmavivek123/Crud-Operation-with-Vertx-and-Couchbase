import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.util.features.CouchbaseFeature;
import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;
import io.vertx.core.json.Json;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import com.couchbase.client.java.query.N1qlQuery;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*-1111------how to start a server---------

public class MainVertex extends AbstractVerticle{
    private HttpServer httpServer=null;

    public static void main(String[] args) {
        Launcher.executeCommand("run" , MainVertex.class.getName());
    }

    @Override
    public void start(Future<Void> f1){
        httpServer=vertx.createHttpServer();
        httpServer.listen(8080);
    }

}
*/
//----222-----startin server and listening.......port .......

/*

public class MainVertex extends AbstractVerticle{
    private HttpServer httpServer=null;

    public static void main(String[] args) {
        Launcher.executeCommand("run" ,MainVertex.class.getName());
    }

    @Override
    public void start(Future<Void> f1) throws Exception{
        httpServer=vertx.createHttpServer();
        httpServer.requestHandler(new Handler<HttpServerRequest>() {
           // @Override
            public void handle(HttpServerRequest httpServerRequest) {
                httpServerRequest.response().end("hello world.....");
                System.out.println("incoming request");
            }
        });


        httpServer.listen(8388);


    }

}
*/
/*

public class MainVertex extends AbstractVerticle{
    HttpServer httpServer=null;

    public static void main(String[] args) {
        Launcher.executeCommand("run",MainVertex.class.getName());
    }

    @Override
    public void start(){
        httpServer=vertx.createHttpServer();
        httpServer.requestHandler(new Handler<HttpServerRequest>() {

            public void handle(HttpServerRequest httpServerRequest) {
                httpServerRequest.response().end("welcome");
                httpServerRequest.getParam("param...........");
                httpServerRequest.uri();
               // httpServerRequest.connection().close();
                System.out.println("listening.........");
            }


        });

httpServer.listen(8881);
    }


}


*/


/*----------htpp:-----------post--------server----

public class MainVertex extends AbstractVerticle{
     HttpServer httpServer=null;
    public static void main(String[] args) {
        Launcher.executeCommand("run",MainVertex.class.getName());
    }
    @Override
    public void start(){
        httpServer=vertx.createHttpServer();

        httpServer.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest httpServerRequest) {
                Buffer buffer=Buffer.buffer();
                System.out.println("incoming calls....");
                if(httpServerRequest.method()== HttpMethod.POST){

                    httpServerRequest.handler(new Handler<Buffer>() {

                        @Override
                        public void handle(Buffer buffer) {
        buffer.appendBuffer(buffer);

                        }
                    });

                 httpServerRequest.endHandler(new Handler<Void>() {
                     @Override
                     public void handle(Void aVoid) {


                         httpServer.close();

                     }
                 }) ;


                }
                HttpServerResponse response = httpServerRequest.response();
                response.setStatusCode(200);
                response.headers()
                        .add("Content-Length", String.valueOf(57))
                        .add("Content-Type", "text/html");
                response.write("Vert.x is alive!");
                response.end();

*/
/*
httpServerRequest.response().headers().add("hello","world").add("india","pakis");


                httpServerRequest.response().end("hello world..");*//*


            }
        });
        httpServer.listen(8581);
    }

}


*/
/*----http---get---client------

public class MainVertex extends AbstractVerticle{

   HttpClient httpClient=null;
    public static void main(String[] args) {
        Launcher.executeCommand("run",MainVertex.class.getName());
    }

@Override
    public void start(){
        httpClient=vertx.createHttpClient();

    httpClient.getNow(80, "tutorials.jenkov.com", "/", new Handler<HttpClientResponse>() {

        @Override
        public void handle(HttpClientResponse httpClientResponse) {

            httpClientResponse.bodyHandler(new Handler<Buffer>() {
                @Override
                public void handle(Buffer buffer) {
                    System.out.println("Response (" + buffer.length() + "): ");
                    System.out.println(buffer.getString(0, buffer.length()));
                }
            });
        }
    });

}



}



*/

/*------for tcp-----socket-------

public class MainVertex extends AbstractVerticle{
    public static void main(String[] args) {
        Launcher.executeCommand("run",MainVertex.class.getName());
    }

    @Override
    public void start(){

        NetServer netServer=vertx.createNetServer();

        netServer.connectHandler(new Handler<NetSocket>() {
            @Override
            public void handle(NetSocket netSocket) {
                System.out.println("it's comimg............");
                netSocket.handler(new Handler<Buffer>() {

                    @Override
                    public void handle(Buffer buffer) {
                        System.out.println("incoming data: "+buffer.length());

                        buffer.getString(0,buffer.length());
                        Buffer outBuffer = Buffer.buffer();
                        outBuffer.appendString("response...");

                        netSocket.write(outBuffer);
                    }
                });


            }
        });

        netServer.listen(10000);
    }

}





*/

//---------by second block----------

/*
public class MainVertex extends AbstractVerticle{
    public static void main(String[] args) {
        Launcher.executeCommand("run",MainVertex.class.getName());
    }

    @Override
    public void start(Future<Void> f){
        vertx.createHttpServer().requestHandler(r->{
            r.response().end("hello world");

        }).listen(config().getInteger("http.port",8080),p->{
            if(p.succeeded()){
                System.out.println("it's executing.......");
            }
            else {
                System.out.println("failure........");
            }
        });

    }


}*/


//---------------------CRUD-----------OPERATION-- BY------ MAPPING------------------

/*

public class MainVertex extends AbstractVerticle{
    public static void main(String[] args) {

        Launcher.executeCommand("run",MainVertex.class.getName());
    }
private static ObjectMapper objectMapper=new ObjectMapper();


    private Map<Integer, Whisky> products = new LinkedHashMap<>();
    // Create some product
    private void createSomeData() {
        Whisky b1=new Whisky(1,"vivek","india");
        products.put(b1.getId(),b1);
        Whisky b2=new Whisky(2,"sharma","usa");
        products.put(b2.getId(),b2);
        Whisky b3=new Whisky(3,"rahul","uk");
        products.put(b3.getId(),b3);
 }


    @Override
    public void start(Future<Void> fut) throws IOException {


        createSomeData();


        Router router = Router.router(vertx);

        ObjectMapper objectMapper=new ObjectMapper();

        router.route("/").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
        });


        router.route("/assets/all").handler(BodyHandler.create());



        router.get("/assets/all").handler(this::getAll);

  router.get("/assets/all/:id").handler(this::finone);

  router.post("/assets/all").handler(this::addOne1);

  router.delete("/assets/all/:id").handler(this::deleteone);


router.route("/assets/all/:id").handler(BodyHandler.create());
  router.put("/assets/all/:id").handler(this::update1);


  //router.get("/assets/all/:id1/:id2").handler(this::findBetween);

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        8972,
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );
    }

    private void getAll(RoutingContext routingContext) {


        routingContext.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encode(products));
    }


    private void finone(RoutingContext routingContext){
String id=routingContext.request().getParam("id");
        System.out.println(id);
        final Integer id2=Integer.valueOf(id);
        System.out.println(id2);
        Whisky found=products.get(id2);
        System.out.println(found);
        routingContext.response().setStatusCode(201)
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encode(found));
    }

    private void addOne1(RoutingContext routingContext)  {
        String s1=routingContext.getBodyAsString();
        System.out.println("NEW VALUE. in json......."+s1);
        Whisky w1=Json.decodeValue(s1,Whisky.class);
        System.out.println(w1);
       Whisky found=products.put(w1.getId(),w1);
        routingContext.response().setStatusCode(209)
                .putHeader("content-type","application/json; charset=utf-8")
                .end(Json.encode(w1));

    }



    private void deleteone(RoutingContext routingContext) {
        String s1=routingContext.request().getParam("id");
        System.out.println(s1);
            Integer i1=Integer.valueOf(s1);
        System.out.println(i1);

            Whisky found=products.remove(i1);
            routingContext.response().setStatusCode(200)
                    .putHeader("content-type","application/json; charset=utf-8")
                    .end(Json.encode(found));

    }

    private void update1(RoutingContext routingContext) {
       String s1=routingContext.getBodyAsString();
        System.out.println("VALUE..............."+s1);
        Whisky whisky=Json.decodeValue(s1,Whisky.class);
        System.out.println(whisky);
        String s2=routingContext.request().getParam("id");
        Integer i1=Integer.valueOf(s2);
        Whisky found= products.put(i1,whisky);
        routingContext.response().setStatusCode(201)

                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encode(Json.encode(found)));
    }

 private void findBetween(RoutingContext routingContext) {
        //String s1=routingContext.request().
        String s1=routingContext.request().getParam("id1");
       // System.out.println(s1);
        Integer i1=Integer.valueOf(s1);
        System.out.println(i1);
        String s2=routingContext.pathParam("id2");
       // System.out.println(s2);
        Integer i2=Integer.valueOf(s2);
        System.out.println(i2);

       List<Whisky> arraylist=new ArrayList<>();
        System.out.println(products.containsValue("id1"));
        System.out.println(products.containsKey("id1"));
         if(!((products.containsValue("id1")) && (products.containsValue("id2")))){
             arraylist.forEach(arraylist::add);

         }
        System.out.println(arraylist);

        routingContext.response().setStatusCode(201)

                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encode(products));
    }






}
*/


///------------------crud operation by using vertx with couchbase-------------------


public class MainVertex extends AbstractVerticle{

Bucket bucket;


    public static void main(String[] args) {


        Launcher.executeCommand("run",MainVertex.class.getName());

    }
private static ObjectMapper objectMapper=new ObjectMapper();


    @Override
    public void start(Future<Void> fut) throws IOException {

        //  createSomeData();
        CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
                //this set the IO socket timeout globally, to 45s
                .socketConnectTimeout((int) TimeUnit.SECONDS.toMillis(10000))
                //this sets the connection timeout for openBucket calls globally (unless a particular call provides its own timeout)
                .connectTimeout(TimeUnit.SECONDS.toMillis(12000))
                .build();
        Cluster cluster= CouchbaseCluster.create(env,"http://127.0.0.1:8091");
         bucket=cluster.openBucket("default","" );
        System.out.println("bucket open........");
        JsonObject products=JsonObject.create();
        JsonDocument document=JsonDocument.create("cb2",products);
        Router router = Router.router(vertx);

        ObjectMapper objectMapper=new ObjectMapper();

        router.route("/").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
        });


        router.route("/assets/all").handler(BodyHandler.create());


        router.post("/assets/all").handler(this::addOne1);
        router.get("/assets/all").handler(this::getAll);

  router.get("/assets/all/:id").handler(this::finone);

        router.delete("/assets/all/:id").handler(this::deleteone);


router.route("/assets/all/:id").handler(BodyHandler.create());
  router.put("/assets/all/:id").handler(this::update1);


  //router.get("/assets/all/:id1/:id2").handler(this::findBetween);

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        8972,
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );
    }


    private void addOne1(RoutingContext routingContext)  {
        String s1=routingContext.getBodyAsString();

        Whisky whisky=null;
        try{
            whisky = new ObjectMapper().readValue(s1, Whisky.class);

        }catch (Exception e){
                e.getCause();
        }

        System.out.println("NEW VALUE........"+s1);

        final JsonObject jsonObject = JsonObject.fromJson(s1);
        JsonDocument jsonDocument=JsonDocument.create(String.valueOf(whisky.getId()),jsonObject);

        bucket.upsert(jsonDocument);

        routingContext.response().setStatusCode(209)
                .putHeader("content-type","application/json; charset=utf-8")
                .end(s1);

    }

    private void getAll(RoutingContext routingContext) {

        N1qlQuery qlQuery=N1qlQuery.simple("SELECT * FROM default");
        System.out.println(qlQuery);
        N1qlQueryResult n1qlQueryResult=bucket.query(qlQuery);
        System.out.println(n1qlQueryResult);

        routingContext.response()
                .setStatusCode(200)
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(n1qlQueryResult.allRows().toString());
    }

    private void finone(RoutingContext routingContext){
String id1=routingContext.request().getParam("id");
        System.out.println(id1);
        JsonDocument jsonDocument= bucket.get(id1);
        JsonObject jsonObject = jsonDocument.content();
        System.out.println(jsonObject);
        routingContext.response().setStatusCode(201)
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(jsonObject.toString());
    }

    private void deleteone(RoutingContext routingContext) {
        String s1=routingContext.request().getParam("id");
        System.out.println(s1);

        JsonDocument jsonDocument=bucket.remove(s1);
        System.out.println(jsonDocument.content());

            routingContext.response().setStatusCode(200)
                    .putHeader("content-type","application/json; charset=utf-8")
                    .end(jsonDocument.content().toString());

    }


    private void update1(RoutingContext routingContext) {


        String s1=routingContext.getBodyAsString();
        System.out.println("value of passing body ...............");
        System.out.println("VALUE..............."+s1);
        Whisky whisky=null;
        try{
            whisky = new ObjectMapper().readValue(s1, Whisky.class);

        }catch (Exception e){
            e.getCause();
        }
       System.out.println(whisky.getId());


        JsonObject jsonObject=JsonObject.fromJson(s1);

        JsonDocument jsonDocument=JsonDocument.create(String.valueOf(whisky.getId()),jsonObject);
       bucket.upsert(jsonDocument);

        routingContext.response().setStatusCode(201)

                .putHeader("content-type", "application/json; charset=utf-8")
                .end(jsonDocument.content().toString());
    }

}




















