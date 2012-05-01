package org.magi.quotes.core.util;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author MGW
 */
@RequestScoped
public class NumericUtil implements Serializable
{
    private DecimalFormat amountFormatter;

    @PostConstruct
    protected void init() {
        amountFormatter = new DecimalFormat("#,##0.00");
    }

    public String formatAmount(BigDecimal amount) {
        return amountFormatter.format(amount.doubleValue());
    }
}
