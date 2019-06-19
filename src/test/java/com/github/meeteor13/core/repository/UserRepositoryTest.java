package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.domain.Location;
import com.github.meeteor13.core.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void saveTest() {
        final User user = User.builder()
            .id("1")
            .locations(Arrays.asList(
                Location.builder()
                    .date(LocalDate.now())
                    .point(new Point(2, 3))
                    .build(),
                Location.builder()
                    .date(LocalDate.now())
                    .point(new Point(3, 3))
                    .build()
            ))
            .build();
        final User saved = repository.save(user).block();
        final User found = repository.findById(user.getId()).block();
        assertThat(found).isEqualToComparingFieldByFieldRecursively(saved);
    }
}
