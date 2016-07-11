package org.restful.api.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.restful.api.messenger.database.DatabaseClass;
import org.restful.api.messenger.model.Message;

public class MessageService {

    private final Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
	messages.put(1L, new Message(1, "Hello world", "JR"));
	messages.put(2L, new Message(2, "Hello India", "Ashish"));
    }

    public List<Message> getAllMessages() {
	return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long msgId) {
	return messages.get(msgId);
    }

    public Message addMessage(Message msg) {

	msg.setId(messages.size() + 1);
	messages.put(msg.getId(), msg);
	return msg;
    }

    public Message updateMessage(Message msg) {
	if (msg.getId() == 0) {
	    return null;
	}
	messages.put(msg.getId(), msg);
	return msg;
    }

    public Message removeMessage(long id) {
	return messages.remove(id);
    }

    public List<Message> msgForYear(int year) {
	List<Message> msgListForYear = new ArrayList<Message>();
	Calendar cal = Calendar.getInstance();
	for (Message msg : messages.values()) {
	    cal.setTime(msg.getCreated());
	    if (cal.get(Calendar.YEAR) == year) {
		msgListForYear.add(msg);
	    }
	}
	return msgListForYear;
    }

    public List<Message> getMsgPaginated(int start, int size) {
	List<Message> msgListPaginated = new ArrayList<Message>(
		messages.values());
	if (start + size > msgListPaginated.size()) {
	    return msgListPaginated;
	}
	return msgListPaginated.subList(start, start + size);

    }
}
