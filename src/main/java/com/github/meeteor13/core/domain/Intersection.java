package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@Accessors(chain = true)
@Builder
public class Intersection {
    @Id
    private String id;
    private Set<Long> users;
    private Point point;
    private Place place;
}
