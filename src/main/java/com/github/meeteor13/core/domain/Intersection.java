package com.github.meeteor13.core.domain;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Builder
public class Intersection {
    private Location location;
    private List<User> users;
    private Place place;
}
