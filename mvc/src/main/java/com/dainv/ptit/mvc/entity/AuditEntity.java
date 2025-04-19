package com.dainv.ptit.mvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.Serializable;
import java.time.Instant;

@Data
@EnableJpaAuditing
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity implements Serializable {

    @CreatedDate
    @Column(name = "CREATE_TIME")
    @JsonIgnore
    protected Instant createdTime = Instant.now();

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "LAST_UPDATE")
    @JsonIgnore
    protected Instant updatedTime = Instant.now();
}

