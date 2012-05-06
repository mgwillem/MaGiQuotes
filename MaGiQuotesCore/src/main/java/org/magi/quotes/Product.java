package org.magi.quotes;

import java.math.BigDecimal;

/**
 * @author MGW
 */
public class Product {
    
    private Long id;
    private String description;
    private BigDecimal price;
    private PriceType priceType;

    public Product(Long id, String description, BigDecimal price, PriceType priceType) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.priceType = priceType;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", priceType=" + priceType +
                '}';
    }
}
