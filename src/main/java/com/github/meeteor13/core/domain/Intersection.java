package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Accessors(chain = true)
@Builder
public class Intersection {
    @Id
    private String id;
    private Location location;
    private List<Long> users;
    private Place place;
}
