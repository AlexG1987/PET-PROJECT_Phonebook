package com.pet_project.phonebook.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 4)
    private String lastName;

    @NotBlank
    @Size(min = 4)
    private String firstName;

    @NotBlank
    @Size(min = 4)
    private String patronymicName;

    @NotBlank
    private String mobPhone;

    @NotBlank
    private String homePhone;

    private String address;

    @Email
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

}
