package com.shelterapp.backend.entity;


import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "animal")
@Data
public class    Animal {

    //JSON packet key string must match exactly with column name, case and syntax
    //if not posting booleans, GET request to see the formatting of the column names
    //copy and paste from the ResponseBody, the exact column name
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @NotBlank(message = "Species cannot be left blank.")
    @Size(min = 3, max = 50, message = "Species must be between 3 and 50 characters.")
    private String species;

    @NotBlank(message = "Name cannot be left blank.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    private String name;

    @NotBlank(message = "Color level must not be left blank.")
    @Size(min = 3, max = 50, message = "Color level must be between 3 and 50 characters.")
    private String colorLevel;

    @NotNull
    private LocalDateTime intakeDate;

    @NotNull
    private LocalDateTime exitDate;

    @NotNull
    private boolean adoptable;  //logic for if adoptable is false then rescueOnly must be true and vice versa

    @NotNull
    private boolean rescueOnly; //logic for if rescueOnly is false then adoptable must be true and vice versa
}
