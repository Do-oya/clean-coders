package nameinverter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NameInverterTest {

    NameInverter nameInverter = new NameInverter();

    @Test
    public void name(){
        assertThat(nameInverter.invert(null), is(""));
        assertThat(nameInverter.invert(""), is(""));
        assertThat(nameInverter.invert("name"), is("name"));
        assertThat(nameInverter.invert("first last"), is("last, first"));
        assertThat(nameInverter.invert("  name  "), is("name"));
        assertThat(nameInverter.invert("first     last"), is("last, first"));
        assertThat(nameInverter.invert("Mr. first last"), is("last, first"));
        assertThat(nameInverter.invert("Mrs. first last"), is("last, first"));
        assertThat(nameInverter.invert("first last SR."), is("last, first SR."));
        assertThat(nameInverter.invert("first last BS. Phd."), is("last, first BS. Phd."));
        assertThat(nameInverter.invert(" Rober Martin II esq."), is("Martin, Rober II esq."));
    }
}
