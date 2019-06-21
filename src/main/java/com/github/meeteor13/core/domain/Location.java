package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.geo.Point;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Location {
    private final LocalDate date;
    private final Point point;
}
