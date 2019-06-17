package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Builder
public class User {
    @Id
    private String id;
    private List<Location> locations;
}
