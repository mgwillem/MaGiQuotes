package org.magi.quotes.core.audit.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author MGW
 */
@Embeddable
public class EmbeddableAuditColumns implements AuditColumns, Serializable
{
    @Column(name="CR_DATE", insertable=true, updatable=false)
    private Timestamp creationDate;

    @Column(name="CR_BY")
    private Long createdBy;

    @Column(name="UPD_DATE", insertable=false, updatable=true)
    private Timestamp updateDate;

    @Column(name="UPD_BY")
    private Long updatedBy;

    @Override
    public Timestamp getCreationDate()
    {
        return creationDate;
    }

    @Override
    public void setCreationDate(Timestamp creationDate)
    {
        this.creationDate = creationDate;
    }

    @Override
    public Timestamp getUpdateDate()
    {
        return updateDate;
    }

    @Override
    public void setUpdateDate(Timestamp updateDate)
    {
        this.updateDate = updateDate;
    }

    @Override
    public Long getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Long getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
}
