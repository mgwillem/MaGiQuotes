package org.magi.quotes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class QueryModelTest {

    private QueryModel model;
    private Query pq1;
    private Query pq100;
    private Query pq101;
    private Query pq1000;
    private Query pq1001;
    private Query pq1002;

    @Before
    public void setUp() throws Exception {

        pq1 = new Query(1L, null, new Product(1L, "Calcul de la matiere avec les chants vus (...)", null, null), QueryType.MULTIPLE);
        pq100 = new Query(100L, 1L, new Product(2L, "Calcul de leur surface", new BigDecimal("100"), PriceType.M2), null);
        pq101 = new Query(101L, 1L, new Product(3L, "Totalite des chants à vu", null, null), QueryType.ONE);
        pq1000 = new Query(1000L, 101L, new Product(4L, "Chant poli et biseauté", new BigDecimal("1000"), PriceType.ML), null);
        pq1001 = new Query(1001L, 101L, new Product(5L, "Chant poli et arrondi 1/4 de lune", new BigDecimal("1001"), PriceType.ML), null);
        pq1002 = new Query(1002L, 101L, new Product(6L, "Chant poli et arrondi 1/2 de lune", new BigDecimal("1002"), PriceType.ML), null);

        model = new QueryModel();
        model.init();
    }

    @Test
    public void testAdd() {
        model.add(pq1);
        model.add(pq100);
        model.add(pq101);
        model.add(pq1000);
        model.add(pq1001);
        model.add(pq1002);

        Assert.assertNotNull(model.getModel());
        Assert.assertTrue(model.getModel().size() == 1);
        Assert.assertTrue(pq1.getQueries().size() == 2);
        Assert.assertTrue(pq100.getQueries().isEmpty());
        Assert.assertTrue(pq101.getQueries().size() == 3);
        Assert.assertTrue(pq1000.getQueries().isEmpty());
        Assert.assertTrue(pq1001.getQueries().isEmpty());
        Assert.assertTrue(pq1002.getQueries().isEmpty());

        System.out.println(model);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidParent() {
        model.add(pq100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidParent2() {
        model.add(pq1);
        model.add(pq100);
        model.add(pq1000);
    }
}
