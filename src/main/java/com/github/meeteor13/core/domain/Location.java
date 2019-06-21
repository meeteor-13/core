package com.github.meeteor13.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Accessors(chain = true)
@Builder
public class Location {
    @Id
    @JsonIgnore
    private String id;
    private Long userId;
    private Date date;
    private Point point;
}
