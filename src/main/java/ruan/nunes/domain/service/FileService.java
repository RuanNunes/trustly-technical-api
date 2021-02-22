package ruan.nunes.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import ruan.nunes.domain.File;
import ruan.nunes.domain.GitHubHtml;

@ApplicationScoped
@AllArgsConstructor
public class FileService {
    private static String path = "https://github.com/";
    private GitHubHtmlService gitHubHtmlService;
    private List<File> getFilesInFolder(final String url){
        final String html = Rest.GET(url);
        final List<GitHubHtml> gitHubHtmls = gitHubHtmlService.getGitHubHtmls(html);
        final List<File> files = new ArrayList<>();
        
        gitHubHtmls.forEach( h -> {
            if(h.getTitle().contains(".")){
                files.add(formatFile(h, path.concat(h.getHref())));
            }
        });
        return files;
    }

    
    public List<File> getFiles(final List<GitHubHtml> gitHubHtmls){
        final List<File> files = new ArrayList<>();
        for (GitHubHtml html : gitHubHtmls) {
            final String url = path.concat(html.getHref());
            if(html.isFolder()){
                files.addAll(getFilesInFolder(url));
            }else{
                files.add(formatFile(html, url));
            }  
        }
         
        return files.stream().sorted((o1, o2) -> o1.getType().compareTo(o2.getType())).collect(Collectors.toList());
    }

    private File formatFile(final GitHubHtml html, final String url){
        String title = html.getTitle().replace(".", "#");
        final String [] splitTitle = title.trim().split("#");
        title = splitTitle[0].replace("data-pjax=#repo-content-pjax-container", "");
        final String type = splitTitle[1].replace("data-pjax=", "");
        final String htmlFile = Rest.GET(url);
        final String regex = "<div class=\"text-mono f6 flex-auto pr-3 flex-order-2 flex-md-order-1 mt-2 mt-md-0\">";
        final String regexSubIndex = "<span class=\"file-info-divider\"></span>";
        final String [] splitHtml = htmlFile.split(regex);
        final String [] subSplitHtml = splitHtml[1].split(regexSubIndex);
        final String [] lines = subSplitHtml[0].split(" lines");
        final String [] bytes = subSplitHtml[1].split("</div>");
        
        final String bytesS = bytes[0].trim();
        final int linesI = Integer.parseInt(lines[0].trim()); 
        return File.builder()
                    .url(url)
                    .title(title)
                    .type(type)
                    .size(bytesS)
                    .lines(linesI)
                    .build();
    }
}
