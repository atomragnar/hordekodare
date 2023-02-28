/* package org.hordekodning.alltid.hordekodare.link;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class LinkService {

    List<Link> linkList;

    public LinkService() {
        linkList = new ArrayList<>();
    }

    public void addList(String name, String url){
        linkList.add(new Link(name, url));
    }

    public List<Link> getLinkList() {
        return linkList;
    }
}
 */