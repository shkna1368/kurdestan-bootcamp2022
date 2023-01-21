package com.kurdestan.vertxstarter.book;

import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookHandler {
  private Router router;
  private BookRepository bookRepository;
  private static final Logger LOG = LoggerFactory.getLogger(BookHandler.class);


  public Router getRouter() {
    return router;
  }

  public void setRouter(Router router) {
    this.router = router;
  }

  public BookHandler(Router router) {
    bookRepository = new BookRepository(Vertx.vertx());
    this.router = router;
     addRoutes();

  }

private void addRoutes(){
  getAll();
  createBook();
  deleteBook();
  getBookById();


}
  private void getAll() {

    router.get("/api/books").handler(req -> {
      bookRepository.getAll().onComplete(ar -> {
        if (ar.failed()){
          //Forward error
          req.fail(ar.cause());
          return;
        }
        // Return response
        req.response()
          .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
          .end(ar.result().encode());
      });
    });



  }
  private void deleteBook() {
    router.delete("/api/books/:id").handler(req -> {
      final long id = Long.parseLong(req.pathParam("id"));
      bookRepository.delete(id).onComplete(ar -> {
        if (ar.failed()){
          //Forward error
          req.fail(ar.cause());
          return;
        }
        // Return response
        if (ar.result() == null) {
          //Book not found
          req.response()
            .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
            .setStatusCode(HttpResponseStatus.NOT_FOUND.code())
            .end(new JsonObject().put("error", "Book not found!").encode());
        } else {
          //Deleted a book
          req.response()
            .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
            .end(new JsonObject().put("id", ar.result()).encode());
        }
      });
    });
  }

  private void getBookById() {
    router.get("/api/books/:id").handler(req -> {
      final long id = Long.parseLong(req.pathParam("id"));
      bookRepository.getById(id).onComplete(ar -> {
        if (ar.failed()){
          //Forward error
          req.fail(ar.cause());
          return;
        }
        // Return response
        if (ar.result() == null) {
          //Book not found
          req.response()
            .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
            .setStatusCode(HttpResponseStatus.NOT_FOUND.code())
            .end(new JsonObject().put("error", "Book not found!").encode());
        } else {
          //Deleted a book
          req.response()
            .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
            .end( ar.result().encode());
        }
      });
    });
  }

  private void registerErrorHandler(final Router books) {
    books.errorHandler(500, event -> {
      LOG.error("Failed: ", event.failure());
      if (event.failure() instanceof  IllegalArgumentException) {
        event.response()
          .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
          .setStatusCode(HttpResponseStatus.BAD_REQUEST.code())
          .end(new JsonObject().put("error", event.failure().getMessage()).encode());
        return;
      }
      event.response()
        .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
        .setStatusCode(HttpResponseStatus.INTERNAL_SERVER_ERROR.code())
        .end(new JsonObject().put("error", event.failure().getMessage()).encode());
    });
  }

  private void updateBook(final Router books) {
    books.put("/books/:isbn").handler(req -> {
      final String isbn = req.pathParam("isbn");
      final JsonObject requestBody = req.getBodyAsJson();

    });
  }

  private void createBook() {
    router.post("/books").handler(req -> {
      // Read body
      final JsonObject requestBody = req.getBodyAsJson();
      System.out.println("Request Body: " + requestBody);
      // Store
      bookRepository.add(requestBody.mapTo(Book.class)).onComplete(ar -> {
        if (ar.failed()){
          //Forward error
          req.fail(ar.cause());
          return;
        }
        // Return response
        req.response()
          .putHeader(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON)
          .setStatusCode(HttpResponseStatus.CREATED.code())
          .end(requestBody.encode());
      });
    });
  }



}


