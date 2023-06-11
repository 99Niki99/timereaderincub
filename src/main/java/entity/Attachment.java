package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class Attachment {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy ="uuid2")

    private String id;
    private String team;
    private String cableName;
    private Integer cableLength;

    @Lob

    private byte[] data;

    public Attachment(String team, byte[] data, String cableName, Integer cableLength){
        this.cableLength = cableLength;
        this.cableName = cableName;
        this.team = team;
        this.data = data;
    }
}
