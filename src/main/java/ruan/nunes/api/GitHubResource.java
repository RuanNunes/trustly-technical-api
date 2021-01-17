package ruan.nunes.api;

import ruan.nunes.api.contract.GitHubApi;

public class GitHubResource implements GitHubApi {

	@Override
	public String getInfo() {
		
		return "teste";
	}
    
}
