package org.green.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_no", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "like_code", nullable = false)
    private Character likeCode;

    @Column(name = "like_id", nullable = false)
    private String likeId;

}