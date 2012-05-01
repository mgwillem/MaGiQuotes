package org.magi.quotes.core.audit.entity;

/**
 * @author MGW
 */
public interface AuditableEntity
{
    public EmbeddableAuditColumns getAuditColumns();

    public void setAuditColumns(EmbeddableAuditColumns auditColumns);

}
