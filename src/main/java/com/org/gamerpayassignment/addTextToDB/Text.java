package com.org.gamerpayassignment.addTextToDB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "Text")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String text;

    private Date createdDate;

    @PrePersist
    private void setCreatedDate() {
        this.createdDate = new Date();
    }
}
