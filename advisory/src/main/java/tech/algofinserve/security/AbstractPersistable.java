package tech.algofinserve.security;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractPersistable implements Serializable {
    @Column
    private @NotBlank Date createdOn;
    @Column private @NotBlank String createdBy;
    @Column private @NotBlank String recordStatus;

    public AbstractPersistable() {}

    /*
     * public AbstractPerstistable(Date createdOn,String createdBy,String
     * recordStatus) { this.createdOn=createdOn; this.createdBy=createdBy;
     * this.recordStatus=recordStatus; }
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
