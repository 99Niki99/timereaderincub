package us.nikita.timereaderincub.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class TextDivisionUtilsTest {

    @Test
    public void buildTeam_nullLines_returnsEmptyList(){
       String[] lines = null;
        List<String> teams = TextDivisionUtils.buildTeam(lines);
        assertThat(teams).isEmpty();
    }
    @Test
    public void buildTeam_EmptyLines_returnsEmptyList(){
        String[] lines = new String[]{};
        List<String> teams = TextDivisionUtils.buildTeam(lines);
        assertThat(teams).isEmpty();
    }
    @Test
    public void buildTeam_wrongLines_returnsEmptyList(){
        String[] lines = new String[]{"A 215-10 - 10000 ft"};
        List<String> teams = TextDivisionUtils.buildTeam(lines);
        assertThat(teams).isEmpty();
    }
    @Test
    public void buildTeam_goodLinesOperators_returnFullList(){
        String[] lines = new String[]{"Operator Nikita Oscar"};
        List<String> teams = TextDivisionUtils.buildTeam(lines);
        List<String> check = new ArrayList<>();
        check.add("Operator Nikita Oscar");
        assertThat(teams).isEqualTo(check);
    }

    @Test
    public void buildTeam_goodLinesAssistant_returnFullList(){
        String[] lines = new String[]{"Assistant Ivan"};
        List<String> teams = TextDivisionUtils.buildTeam(lines);
        List<String> check = new ArrayList<>();
        check.add("Assistant Ivan");
        assertThat(teams).isEqualTo(check);
    }


}
