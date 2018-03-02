package com.udemy.springmvcdemo.converters;

import com.udemy.springmvcdemo.commands.UnitOfMeasureCommand;
import com.udemy.springmvcdemo.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private static final String DESCRIPTION = "description";
    private static final Long LONG_VALUE = 1L;
    private UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(LONG_VALUE);
        unitOfMeasure.setTitle(DESCRIPTION);
        //when
        UnitOfMeasureCommand unitOfMeasureCommand = converter.convert(unitOfMeasure);
        //then
        assert unitOfMeasureCommand != null;
        assertEquals(LONG_VALUE, unitOfMeasureCommand.getId());
        assertEquals(DESCRIPTION, unitOfMeasureCommand.getTitle());
    }
}