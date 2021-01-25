package ruan.nunes.domain.service;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import ruan.nunes.domain.GitHubHtml;

/** 
 *  hrml exemple folder
 * 
 *  <div role="rowheader" class="flex-auto min-width-0 col-md-2 mr-3">
 *      <span class="css-truncate css-truncate-target d-block width-fit">
 *          <a class="js-navigation-open link-gray-dark" title="teste" href="/RuanNunes/test/tree/main/teste">teste</a>
 *      </span>
 *  </div>
 * 
 * html exemple file
 * 
 *  <div role="rowheader" class="flex-auto min-width-0 col-md-2 mr-3">
 *    <span class="css-truncate css-truncate-target d-block width-fit">
 *          <a class="js-navigation-open link-gray-dark" title="README.md" href="/RuanNunes/test/blob/main/README.md">README.md</a>
 *    </span>
 *  </div>
 *  
 */

@ApplicationScoped
public class GitHubHtmlService {
    
    public List<GitHubHtml> getGitHubHtmls(final String html){
        final List<GitHubHtml> gitHubHtmlList = new ArrayList<>();
        final String regexSubIndex = "<a class=\"js-navigation-open link-gray-dark\" title=";
        final String[] split = html.split(regexSubIndex);
        for (String string : split) {
            if(string.contains("</a></span>")){
                String[] sliptSubIndex = string.split("href");
                final String title = sliptSubIndex[0].replace("\"", "").trim();
                final String href = sliptSubIndex[1].split("\">")[0].replace("=\"", ""); 
                final boolean isFolder = !title.contains(".");                                              
                gitHubHtmlList.add(GitHubHtml.builder()
                                             .title(title)
                                             .href(href) 
                                             .folder(isFolder)
                                             .build());
            }
        }
        return gitHubHtmlList;
    }
}