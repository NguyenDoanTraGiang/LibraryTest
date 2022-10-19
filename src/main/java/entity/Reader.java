package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "READER")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int phoneNum;
}
