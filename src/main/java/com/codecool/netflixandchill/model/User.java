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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "episode_id"))
    private List<Episode> watchedEpisodes = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Builder
    public User(String userName, String emailAddress, String password, Date registrationDate) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public void addEpisodeToUser(Episode episode) {
        watchedEpisodes.add(episode);
    }
}