package com.isollo.demoapi.student;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "StudentIdCard")
@Table(name = "student_id_card")
@NoArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class StudentIdCard {
    @Id
    @SequenceGenerator(
            name = "student_card_seq",
            sequenceName = "student_card_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_card_seq"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String cardNumber;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }
}
