package com.github.meeteor13.core.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Accessors(chain = true)
public class User {
    private String id;
    private List<Location> locations;
}
