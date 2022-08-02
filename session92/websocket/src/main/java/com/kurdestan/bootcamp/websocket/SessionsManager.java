package com.kurdestan.bootcamp.websocket;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;
@Component
@Data
public class SessionsManager {
    private Map<Integer,WebSocketSession> sessions;

    public SessionsManager() {
        sessions= Collections.synchronizedMap(new HashMap<Integer, WebSocketSession>());
    }

    public void add(int id,WebSocketSession webSocketSession){
        sessions.put(id,webSocketSession);
    }


      public void remove(int id){
        sessions.remove(id);
    }




}