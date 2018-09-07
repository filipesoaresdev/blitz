package br.gov.pi.detran.ouvidoria.modelo.audit;

import com.xpert.audit.model.AbstractAuditing;
import com.xpert.audit.model.AbstractMetadata;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Index;

/**
 *
 * @author
 */
@Entity
public class Metadata extends AbstractMetadata implements Serializable {

    @Id
    @SequenceGenerator(name = "Metadata", allocationSize = 1, sequenceName = "metadata_id_seq")
    @GeneratedValue(generator = "Metadata")
    private Long id;

    @Index(name="idx_metadata_auditing")
    @ManyToOne
    private Auditing auditing;

    @Override
    public Long getId() {
        return id;
    }

    /**
     * max size to be save in coluns "newValue" and "oldValue"
     *
     * @return
     */
    @Override
    public Integer getMaxSizeValues() {
        return 255;
    }

    @Override
    public AbstractAuditing getAuditing() {
        return auditing;
    }

    @Override
    public void setAuditing(AbstractAuditing auditing) {
        this.auditing = (Auditing) auditing;
    }
}
