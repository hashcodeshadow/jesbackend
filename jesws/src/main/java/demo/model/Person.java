package demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Embeddable
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column
    public String firstName;
    @Column
    public String lastName;
    @Column
    public String email;
    @Column
    public Boolean active;
}
