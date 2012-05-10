package org.magi.quotes;

import org.magi.quotes.QueryModel;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class QueryModelFactory {

    @Produces @QueryModelType @ApplicationScoped
    public QueryModel createQueryModel() {

        QueryModel queryModel = new QueryModel();
        queryModel.init();

        queryModel.add(new Query(10L, null, new Product(10L, "Category one", null, null), QueryType.MULTIPLE));
        queryModel.add(new Query(20L, 10L, new Product(20L, "Product one - Category one", BigDecimal.TEN, PriceType.PC), null));
        queryModel.add(new Query(30L, 10L, new Product(30L, "Product two - Category one", BigDecimal.TEN, PriceType.PC), null));

        queryModel.add(new Query(40L, null, new Product(40L, "Category two", null, null), QueryType.MULTIPLE));
        queryModel.add(new Query(50L, 40L, new Product(50L, "Product one - Category two", BigDecimal.ONE, PriceType.M2), null));
        queryModel.add(new Query(60L, 40L, new Product(60L, "Product two - Category two", BigDecimal.ONE, PriceType.M2), null));

        return queryModel;
    }

}
