package us.nikita.timereaderincub.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TextDivisionUtilsTest {

    @Test
    public void buildTeam_nullLines_returnsEmptyList(){
       String[] lines = null;
        List<String> teams = TextDivisionUtils.buildTeam(lines);
        assertThat(teams).isEmpty();
    }
}
