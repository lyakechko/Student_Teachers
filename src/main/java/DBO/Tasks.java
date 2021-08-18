package DBO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Tasks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "mark")
    private Integer mark;
    @Column(name = "review")
    private String review;
    @Column(name = "cours")
    private String cours;

    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Students.class)
    @JoinColumn(name = "id_student",insertable = false, updatable = false)
    private Students students;

}
