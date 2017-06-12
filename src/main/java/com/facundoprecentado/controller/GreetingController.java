package com.facundoprecentado.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facundoprecentado.domain.Message;

@Controller
public class GreetingController {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping (path = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public Message message(Message message) throws Exception {
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return new Message(sdf.format(timestamp) + " > " + message.getContent());
    }
    
}
