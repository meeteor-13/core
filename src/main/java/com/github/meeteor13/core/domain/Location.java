package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@Builder
public class Location {
    @Id
    private String id;
    private Long userId;
    private LocalDate date;
    private Point point;
}
