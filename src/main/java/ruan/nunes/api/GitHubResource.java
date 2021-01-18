package ruan.nunes.api;

import java.util.ArrayList;
import java.util.List;

import ruan.nunes.api.contract.GitHubApi;
import ruan.nunes.domain.File;
import ruan.nunes.domain.RepositoryDTO;

public class GitHubResource implements GitHubApi {

	@Override
	public RepositoryDTO getInfo(final String url) {
        List<File> files = new ArrayList<>();
        File file = new File("test","xml",12,12);
        files.add(file);
        
		return new RepositoryDTO(files);
	}
    
}
