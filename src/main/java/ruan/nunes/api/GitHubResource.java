package ruan.nunes.api;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import ruan.nunes.api.contract.GitHubApi;
import ruan.nunes.domain.File;
import ruan.nunes.domain.GitHubHtml;
import ruan.nunes.domain.RepositoryDTO;
import ruan.nunes.domain.service.FileService;
import ruan.nunes.domain.service.GitHubHtmlService;
import ruan.nunes.domain.service.Rest;

@AllArgsConstructor
public class GitHubResource implements GitHubApi {

	private GitHubHtmlService gitHubHtmlService;
	private FileService fileService;

	@Override
	public RepositoryDTO getInfo(final String url) {
		final List<GitHubHtml> gitHubHtmls = gitHubHtmlService.getGitHubHtmls(Rest.GET(url));
        List<File> files = fileService.getFiles(gitHubHtmls);
		return new RepositoryDTO(url,files,gitHubHtmls);
	}
    
}
