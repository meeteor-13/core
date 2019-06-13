package com.github.meeteor13.core.domain;

import com.mongodb.client.model.geojson.Point;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Location {
    private LocalDateTime date;
    private Point point;
}
