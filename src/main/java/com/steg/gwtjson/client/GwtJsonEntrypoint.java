package com.steg.gwtjson.client;

import java.util.List;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.xhr.client.ReadyStateChangeHandler;
import com.google.gwt.xhr.client.XMLHttpRequest;

public class GwtJsonEntrypoint implements EntryPoint {
	// public static interface PostMapper extends ObjectMapper<Post> {
	// }

	public static interface UsersMapper extends ObjectMapper<List<User>> {
	}

	@Override
	public void onModuleLoad() {
		XMLHttpRequest xhr = XMLHttpRequest.create();
		xhr.open("GET", "https://jsonplaceholder.typicode.com/users");
		xhr.send();
		xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {

			@Override
			public void onReadyStateChange(XMLHttpRequest xhr) {
				if (xhr.getReadyState() == XMLHttpRequest.DONE) {
					UsersMapper mapper = GWT.create(UsersMapper.class);

					List<User> users = mapper.read(xhr.getResponseText());

					RootPanel.get().add(new Label(users.size() + " " + users.get(0).getAddress().getCity()));
				}
			}
		});
		// XMLHttpRequest xhr = XMLHttpRequest.create();
		// xhr.open("GET", "https://jsonplaceholder.typicode.com/posts/1");
		// xhr.send();
		// xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {
		//
		// @Override
		// public void onReadyStateChange(XMLHttpRequest xhr) {
		// if (xhr.getReadyState() == XMLHttpRequest.DONE) {
		// PostMapper mapper = GWT.create(PostMapper.class);
		//
		// PostAutoValue post = mapper.read(xhr.getResponseText());
		//
		// RootPanel.get().add(new Label(post.getTitle()));
		// }
		// }
		// });
	}
}
