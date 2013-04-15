package org.elasticsearch.river.couchdb.kernel.index;

import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class LastSeqFormatterTest {

    private LastSeqFormatter formatter = new LastSeqFormatter("db");

    @Test
    public void shouldFormatLastSeqWhenItsGivenAsAString() throws Exception {
        // given
        Object lastSeq = "1337";

        // when
        String output = formatter.format(lastSeq);

        // then
        assertThat(output).isEqualTo("1337");
    }

    @Test
    public void shouldFormatLastSeqWhenItsGivenAsAList() throws Exception {
        // given
        List<?> lastSeq = Arrays.asList(1337, "here goes the hash");

        // when
        String output = formatter.format(lastSeq);

        // then
        assertThat(output).isEqualTo("[1337,\"here goes the hash\"]");
    }
}
