package com.github.meeteor13.core.domain;

import com.mongodb.client.model.geojson.Point;
import lombok.Data;
import lombok.experimental.Accessors;
    import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Accessors(chain = true)
public class Place {
    private String id;
    private String title;
    private String address;
    private Point point;
}
