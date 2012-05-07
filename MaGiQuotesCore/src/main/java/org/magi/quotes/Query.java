package org.magi.quotes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class Query {
    private Long id;
    private Long parentId;
    private Product product;
    private QueryType queryType;
    private List<Query> queries;

    public Query(Long id, Long parentId, Product product, QueryType queryType) {
        this.id = id;
        this.parentId = parentId;
        this.product = product;
        this.queryType = queryType;
        this.queries = new ArrayList<Query>();
    }

    public Long getId() {
        return id;
    }

    public Long getParentId() {
        return parentId;
    }

    public Product getProduct() {
        return product;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public List<Query> getQueries() {
        return queries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Query that = (Query) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", product=" + product +
                ", queryType=" + queryType +
                ", queries=" + queries +
                '}';
    }
}
