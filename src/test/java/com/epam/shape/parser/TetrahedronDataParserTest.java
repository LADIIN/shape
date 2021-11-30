package com.epam.shape.parser;

import com.epam.shape.exception.TetrahedronException;
import com.epam.shape.parser.impl.TetrahedronDataParserImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TetrahedronDataParserTest {

    @Test
    public void testAddShouldParseStringToDoublesListWhenStringListIsCorrect() throws TetrahedronException {
        //given
        TetrahedronDataParserImpl tetrahedronDataParser = new TetrahedronDataParserImpl();

        List<String> data = Arrays.asList(
                "2.5 3 2.5 61.0   1 3 4 6 1.0 -4 1.0 -2.4",
                "",
                "13 1231.0 12f.0 123.0 1 4 5 -4 1 3 5 0   ",
                "1 0 0 0 0 0 0 0 0 0 0 0");

        //when
        List<double[]> actual = tetrahedronDataParser.parseStringToDouble(data);

        //then
        List<double[]> expected = Arrays.asList(
                new double[]{2.5, 3, 2.5, 61, 1, 3, 4, 6, 1, -4, 1, -2.4},
                new double[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        assertThat(actual).containsExactlyElementsOf(expected);

    }

    @Test(expected = TetrahedronException.class)
    public void testAddShouldThrowExceptionWhenStringListIsNull() throws TetrahedronException {
        //given
        TetrahedronDataParserImpl tetrahedronDataParser = new TetrahedronDataParserImpl();
        List<String> data = null;

        //when
        List<double[]> actual = tetrahedronDataParser.parseStringToDouble(data);
    }

}
