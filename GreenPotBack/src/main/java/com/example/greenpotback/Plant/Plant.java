package com.example.greenpotback.Plant;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String name;

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

    @ManyToMany
    @JoinTable(
            name = "plant_subCategory",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "subCategory_id"))
    private List<SubCategory> subCategories = new ArrayList<>();

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Calendar> calendar = new ArrayList<>();
}
