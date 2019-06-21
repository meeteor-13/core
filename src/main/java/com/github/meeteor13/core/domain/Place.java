package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Place {
    @Id
    private String id;
    private String title;
    private String address;
    private Point point;
}
