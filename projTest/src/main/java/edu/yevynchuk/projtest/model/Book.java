package edu.yevynchuk.projtest.model;

/*
    @author Nibe
    @project projTest
    @class Book
    @version 1.0.0
    @SE 05.10.2024 - 21:03
*/

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Book {
    private String id;
    private String title;
    private String code; // Серійний номер
    private String description;

    public Book(String title, String code, String description) {
        this.title = title;
        this.code = code;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
