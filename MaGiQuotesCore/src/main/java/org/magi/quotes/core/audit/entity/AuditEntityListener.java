package org.magi.quotes.core.audit.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class AuditEntityListener
{
    @PrePersist
    void onCreate(Object target)
    {
        if (target instanceof AuditableEntity)
        {
            AuditableEntity entity = (AuditableEntity)target;
            
            //if (entity.getAuditColumns() == null) throw new IllegalStateException("The auditable entity is not properly initialized!");
            if (entity.getAuditColumns() == null) return; // The audit interceptor has been disabled.

            if (entity.getAuditColumns().getCreatedBy() == null) throw new IllegalStateException("The auditable entity is not properly initialized (created by)!");
            if (entity.getAuditColumns().getCreationDate() == null) throw new IllegalStateException("The auditable entity is not properly initialized (creation date)!");
        }
    }

    @PreUpdate
    void onUpdate(Object target)
    {
        if (target instanceof AuditableEntity)
        {
            AuditableEntity entity = (AuditableEntity)target;

            //if (entity.getAuditColumns() == null) throw new IllegalStateException("The auditable entity is not properly initialized!");
            if (entity.getAuditColumns() == null) return; // The audit interceptor has been disabled.

            if (entity.getAuditColumns().getUpdatedBy() == null) throw new IllegalStateException("The auditable entity is not properly initialized (updated by)!");
            if (entity.getAuditColumns().getUpdateDate() == null) throw new IllegalStateException("The auditable entity is not properly initialized (update date)!");
        }
    }
}
