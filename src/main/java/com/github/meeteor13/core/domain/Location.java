package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.geo.Point;

import java.time.LocalDateTime;

@Getter
@Builder
public class Location {
    private final LocalDateTime date;
    private final Point point;
}
