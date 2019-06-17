package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Builder
public class Place {
    private String id;
    private String title;
    private String address;
    private Point point;
}
