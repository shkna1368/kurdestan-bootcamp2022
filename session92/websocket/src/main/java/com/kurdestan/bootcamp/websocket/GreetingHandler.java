package com.kurdestan.bootcamp.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GreetingHandler extends TextWebSocketHandler {
@Autowired
SessionsManager sessionsManager;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws InterruptedException, IOException {




        System.out.println("uri="+session.getUri());
        System.out.println("uri="+session.getRemoteAddress());

        System.out.println("here="+message.getPayload());







        for (WebSocketSession socketSession:sessionsManager.getSessions().values()){
        if (!socketSession.equals(session)) {
            socketSession.sendMessage(new TextMessage(message.getPayload() + "-" + System.currentTimeMillis()));
}
        }
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        //the messages will be broadcasted to all users.
        System.out.println("id="+session.getId());


        System.out.println("uri="+session.getUri());
        System.out.println("uri="+session.getRemoteAddress());

        int id  = getSessionId(session);

        System.out.println("connected");
        session.sendMessage(new TextMessage("You are now connected to the server. This is the first message from server....."));
        sessionsManager.add(id,session);

    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Connection Closed！"+status);
        sessionsManager.remove(getSessionId(session));
    }



private int getSessionId(WebSocketSession session){

    return   Integer.parseInt(new AntPathMatcher()
            .extractPathWithinPattern( "/{id}/**", session.getUri().getPath() ));
}
}