package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.domain.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository repository;

    @Test
    public void saveTest() {
        final Location saved = repository.save(Location
            .builder()
            .userId(1L)
            .date(LocalDate.now())
            .point(new Point(2, 3))
            .build()).block();
        final Location found = repository.findById(saved.getId()).block();
        assertThat(found).isEqualToComparingFieldByFieldRecursively(saved);
    }
}
