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
    private String cableName;
    private int cableLength;
    private int tottalLengthForDay;

    @Lob

    private byte[] data;

    public Attachment(String cableName, int cableLength, int tottalLengthForDay, byte[] data){
        this.cableName =cableName;
        this.cableLength = cableLength;
        this.tottalLengthForDay = tottalLengthForDay;
        this.data = data;
    }
}
