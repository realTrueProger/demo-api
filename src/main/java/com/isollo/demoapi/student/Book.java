package com.isollo.demoapi.student;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Book")
@Table(name = "book")
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

    public Book() {
    }

    public Book(LocalDateTime createdAt, Student student, String bookName) {
        this.createdAt = createdAt;
        this.student = student;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", student=" + student +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
