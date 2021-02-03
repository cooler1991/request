package com.ocrv.request.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "comment" )
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @JsonIgnore
    public Request getRequest() {
        return request;
    }
    }
/*
    @Column
    private Integer request_id;

*/



