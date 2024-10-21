package ma.rimtelecomback.Entities;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Data @NoArgsConstructor @AllArgsConstructor
@Embeddable
public class Arch1004901Id implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;
    private int idDevice;

}

