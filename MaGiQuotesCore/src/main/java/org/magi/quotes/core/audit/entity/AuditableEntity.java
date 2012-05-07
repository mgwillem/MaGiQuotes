package org.magi.quotes.core.audit.entity;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public interface AuditableEntity
{
    public EmbeddableAuditColumns getAuditColumns();

    public void setAuditColumns(EmbeddableAuditColumns auditColumns);

}
