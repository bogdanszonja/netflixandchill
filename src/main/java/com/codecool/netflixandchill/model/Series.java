package com.codecool.netflixandchill.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Series extends BaseModel {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Temporal(TemporalType.DATE)
    private Date airDate;

    @OneToMany(mappedBy = "series")
    @Column(nullable = false)
    private List<Season> seasons = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class)
    @Column(name = "genre", nullable = false)
    private List<Genre> genres = new ArrayList<>();

    public void addSeason(Season season) {
        seasons.add(season);
    }
}
