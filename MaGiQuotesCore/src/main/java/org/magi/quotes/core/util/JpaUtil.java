package org.magi.quotes.core.util;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@RequestScoped
public class JpaUtil 
{
    public String extractPersistentTableName(Class entity)
    {
        Table table = (Table)entity.getAnnotation(Table.class);
        if (table == null) throw new IllegalArgumentException("Specified class is not an entity");
        
        return table.name();
    }

    public List<String> extractPersistentColumnNameList(Class entity)
    {
        extractPersistentTableName(entity); // Specified class must be an entity

        List<String> columnNameList = new ArrayList<String>();
        
        Field[] fields = entity.getDeclaredFields();
        for (Field field : fields)
        {
            Column col = field.getAnnotation(Column.class);
            if (col != null)
            {
                columnNameList.add(col.name());
            }
        }

        Collections.sort(columnNameList);
        return columnNameList;
    }
}
