package com.nylas;

import java.io.IOException;
import java.util.List;

/**
 * @see https://docs.nylas.com/reference#webhooks
 */
public class Webhooks extends RestfulCollection<Webhook, UnsupportedQuery> {

	Webhooks(NylasClient client, NylasApplication application) {
		super(client, Webhook.class, "a/" + application.getClientId() + "/webhooks", application.getClientSecret());
	}

	@Override
	public List<Webhook> list() throws IOException, RequestFailedException {
		return super.list();
	}

	@Override
	public Webhook get(String id) throws IOException, RequestFailedException {
		return super.get(id);
	}

	@Override
	public Webhook create(Webhook model) throws IOException, RequestFailedException {
		return super.create(model);
	}

	@Override
	public Webhook update(Webhook model) throws IOException, RequestFailedException {
		return super.update(model);
	}

	@Override
	public void delete(String id) throws IOException, RequestFailedException {
		super.delete(id);
	}
	
}