package com.github.meeteor13.core.domain;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Accessors(chain = true)
public class Intersection {
    private Location location;
    private List<User> users;
    private Place place;
}
