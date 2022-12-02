package com.example.greenpotback.Plant;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.example.greenpotback.User.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @Column(length = 16383)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MainCategory category;

    @JsonIgnore
    @OneToMany(
            mappedBy = "plant",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Image> images = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "plant_sub_category",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_category_id"))
    private List<SubCategory> subCategories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Calendar> calendar = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "observedPlant")
    private List<User> observers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;
}
