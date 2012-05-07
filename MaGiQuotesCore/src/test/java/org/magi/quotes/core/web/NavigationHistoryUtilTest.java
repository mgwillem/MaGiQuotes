package org.magi.quotes.core.web;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class NavigationHistoryUtilTest {

    @Test
    public void testExtractViewId() throws Exception {
        Assert.assertEquals("/myuri", NavigationHistoryUtil.extractViewId("/faces/myuri.xhtml"));
        Assert.assertEquals("/myuri.html", NavigationHistoryUtil.extractViewId("/faces/myuri.html"));
        Assert.assertEquals("/myuri.html", NavigationHistoryUtil.extractViewId("/myuri.html"));
    }

}
