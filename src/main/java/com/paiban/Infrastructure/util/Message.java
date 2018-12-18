package com.paiban.Infrastructure.util;

/**
 * 消息
 */
public class Message {
	public Message() {
		code=-1;
	}

	public Message(long Count, Object Data) {
		this.count = Count;
		this.data = Data;
	}

	public int code;
	public String msg;
	public long count;
	public Object data;
}
