package com.kurdestan.vertxstarter;

import com.kurdestan.vertxstarter.book.BookHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

public class Application extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {


    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.route("/*").handler(StaticHandler.create());


    new BookHandler(router);
   // new AuthorHandler(router);

var server=  vertx.createHttpServer();

server.requestHandler(router).listen(8080,"0.0.0.0",httpServerAsyncResult ->{
        if(httpServerAsyncResult.succeeded()){

          startPromise.complete();
          System.out.println("HTTP server start on 8080");
        }
        else
        {
          startPromise.fail(httpServerAsyncResult.cause());


        }
      }


    );

  }

  public static void main(String[] args) {

    Vertx vertx=Vertx.vertx();
    vertx.deployVerticle(new Application());

   /* router


      .route("/hi").handler(ctx -> {

      // This handler will be called for every request
      HttpServerResponse response = ctx.response();
      response.putHeader("content-type", "text/plain");

      // Write to the response and end it
      response.end("Hello World from Vert.x-Web!");
    });


    router
     .route("/bye").handler(ctx -> {

      // This handler will be called for every request
      HttpServerResponse response = ctx.response();
      response.putHeader("content-type", "text/plain");

      // Write to the response and end it
      response.end("Hello World from Vert.x-Web Bye!");
    });



    router.route("/json")
      .produces("application/json")
      .handler(ctx -> {

        HttpServerResponse response = ctx.response();

        // Get the actual MIME type acceptable
        String acceptableContentType = ctx.getAcceptableContentType();

        response.putHeader("content-type", acceptableContentType);


        JsonObject json = new JsonObject()
          .put("servers", new JsonArray()
            .add(new JsonObject()
              .put("host", "server1.datagrid.mycorp.int")
              .put("username", "foo")
              .put("password", "bar"))
            .add(new JsonObject()
              .put("host", "server2.datagrid.mycorp.int")
              .put("username", "foo")
              .put("password", "bar"))
          );

        response.end(json.toString());
      });
*/



  }


}
