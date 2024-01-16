package com.isollo.demoapi.student;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Book")
@Table(name = "book")
@NoArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_seq",
            sequenceName = "book_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_seq"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String bookName;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_book_fk")
    )
    private Student student;

    public Book(LocalDateTime createdAt, Student student, String bookName) {
        this.createdAt = createdAt;
        this.student = student;
        this.bookName = bookName;
    }
}
