package com.nylas;

import java.io.IOException;

import okhttp3.HttpUrl;

public class NylasAccount {

	private final NylasClient client;
	private final String accessToken;
	
	NylasAccount(NylasClient client, String accessToken) {
		this.client = client;
		this.accessToken = accessToken;
	}

	public NylasClient getClient() {
		return client;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public Threads threads() {
		return new Threads(client, accessToken);
	}
	
	public Messages messages() {
		return new Messages(client, accessToken);
	}
	
	public Folders folders() {
		return new Folders(client, accessToken);
	}
	
	public Labels labels() {
		return new Labels(client, accessToken);
	}
	
	public Drafts drafts() {
		return new Drafts(client, accessToken);
	}
	
	public Files files() {
		return new Files(client, accessToken);
	}
	
	public Account fetchAccountByAccessToken() throws IOException, RequestFailedException {
		HttpUrl accountUrl = client.getBaseUrl().resolve("account");
		return client.executeGet(accessToken, accountUrl, Account.class);
	}
	
	public void revokeAccessToken() throws IOException, RequestFailedException {
		HttpUrl revokeUrl = client.getBaseUrl().resolve("oauth/revoke");
		client.executePost(accessToken, revokeUrl, null, null);
	}
	
	
}