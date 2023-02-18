package me.code.backend;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(
            name = "USR_ID_SQS",
            sequenceName = "USR_ID_SQS"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USR_ID_SQS"
    )
    private Integer usrId;
    private String firstName;
    private String lastName;
    private Date birthDate;
}
