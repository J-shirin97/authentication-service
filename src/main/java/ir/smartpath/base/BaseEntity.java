package ir.smartpath.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Prevent database from being locked
    @Version
    private Integer version;

    //on what date was it created
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    //On which person was it created
    @CreatedBy
    private String createdBy;


    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;


    @LastModifiedBy
    private String lastModifiedBy;
}
