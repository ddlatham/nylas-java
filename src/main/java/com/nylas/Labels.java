package com.nylas;

import java.io.IOException;

/**
 * <a href="https://docs.nylas.com/reference#labels">https://docs.nylas.com/reference#labels</a>
 */
public class Labels extends RestfulDAO<Label> {
	
	Labels(NylasClient client, String accessToken) {
		super(client, Label.class, "labels", accessToken);
	}
	
	public RemoteCollection<Label> list() throws IOException, RequestFailedException {
		return list(new LabelQuery());
	}
	
	public RemoteCollection<Label> list(LabelQuery query) throws IOException, RequestFailedException {
		return super.list(query);
	}

	@Override
	public Label get(String id) throws IOException, RequestFailedException {
		return super.get(id);
	}

	public Label create(String displayName) throws IOException, RequestFailedException {
		return super.create(Maps.of("display_name", displayName));
	}
	
	@Override
	public void delete(String labelId) throws IOException, RequestFailedException {
		super.delete(labelId);
	}
	
	/**
	 * Change the display name of the given label.
	 * These changes will propagate back to the account provider.
	 * Note that the core labels such as Inbox, Trash, etc. cannot be renamed.
	 */
	public Label setDisplayName(String labelId, String displayName) throws IOException, RequestFailedException {
		return super.update(labelId, Maps.of("display_name", displayName));
	}
}
