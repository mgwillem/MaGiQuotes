package org.magi.quotes;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class QueryModel implements Serializable {

    private List<Query> model;

    @PostConstruct
    protected void init() {
        model = new ArrayList<Query>();
    }

    public void add(Query query) {
        if (query == null) throw new IllegalArgumentException("Argument cannot be null");
        if (query.getId() == null && query.getParentId() == null) throw new IllegalArgumentException("Id and parent id cannot be null");

        if (query.getParentId() == null) {
            if (model.contains(query)) throw new IllegalArgumentException("Argument has an already existing 'id'");
            
            model.add(query);
        }
        else {
            Query parentQuery = findParent(model, query);
            if (parentQuery == null) throw new IllegalArgumentException("Cannot find parent");

            parentQuery.getQueries().add(query);
        }
    }
    
    public List<Query> getModel() {
        return Collections.unmodifiableList(model);
    }
    
    private Query findParent(List<Query> products, Query query) {

        for (Query pq : products)
        {
            if (pq.getId() == query.getParentId()) return pq;
            
            Query parent = findParent(pq.getQueries(), query);
            if (parent != null) return parent;
        }

        return null;
    }

    @Override
    public String toString() {
        return "QueryModel{" +
                "model=" + model +
                '}';
    }
}
