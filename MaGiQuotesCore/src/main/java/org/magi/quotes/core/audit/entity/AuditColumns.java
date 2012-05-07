package org.magi.quotes.core.audit.entity;

import java.sql.Timestamp;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public interface AuditColumns
{
    public Timestamp getCreationDate();

    public void setCreationDate(Timestamp creationDate);

    public Timestamp getUpdateDate();

    public void setUpdateDate(Timestamp updateDate);

    public Long getCreatedBy();

    public void setCreatedBy(Long createdBy);

    public Long getUpdatedBy();
    
    public void setUpdatedBy(Long updatedBy);
}
