package com.example.web4back.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EntryBean implements Serializable {

    @Id
    @SequenceGenerator(name = "entrySeq", sequenceName = "ENTRY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrySeq")
    @Column(updatable = false, nullable = false)
    private Long id;
    private Double x;
    private Double y;
    private Double r;
    private Boolean isHit;
}
