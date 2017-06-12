package com.facundoprecentado.domain;

public class Message {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Message(String content) {
		super();
		this.content = content;
	}

	public Message() {
		super();
	}

	@Override
	public String toString() {
		return "Message [content=" + content + "]";
	}

}
