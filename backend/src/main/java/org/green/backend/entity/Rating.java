package org.green.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_ratings")
public class Rating {
    @EmbeddedId private RatingId id;

    @Column(name = "jr_star", nullable = false) private Float jrStar;

    @Column(name = "regist_dt", nullable = false) private Instant registDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private Company company;


}