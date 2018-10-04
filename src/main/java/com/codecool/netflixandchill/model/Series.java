package com.codecool.netflixandchill.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)

public class Series extends BaseModel {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Temporal(TemporalType.DATE)
    private Date airDate;

    @Builder.Default
    @OneToMany(mappedBy = "series")
    @Column(nullable = false)
    private List<Season> seasons = new ArrayList<>();

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class)
    @Column(name = "genre", nullable = false)
    private List<Genre> genres = new ArrayList<>();

    public void addSeason(Season season) {
        seasons.add(season);
    }
}
