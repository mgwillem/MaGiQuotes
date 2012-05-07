package org.magi.quotes.core.util;

import java.lang.reflect.Field;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class QualifiedNameExtension implements Extension
{
    void processAnnotatedType(@Observes ProcessAnnotatedType event)
    {
        AnnotatedType annotatedType = event.getAnnotatedType();
        Stateless slsb = annotatedType.getAnnotation(Stateless.class);
        if (slsb != null)
        {
            Class javaClass = annotatedType.getJavaClass();
            System.out.println(":::extension found stateless bean:::" + javaClass.getName());
            
            for (Field field : javaClass.getDeclaredFields())
            {
                System.out.println("::::::having field:::" + field.getName());
            }
        }
    }
}
