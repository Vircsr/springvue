package com.acgames.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="comic")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "comic_list_id")
    private ComicList comicList;

    private int section_id;
    private String section_name;
    private String video_url;
    private Timestamp create_time;
    private Timestamp update_time;

}
