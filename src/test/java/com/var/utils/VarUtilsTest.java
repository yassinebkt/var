package com.var.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

// @RunWith(Runner.class)
public class VarUtilsTest {

    @Test
    public void isValidFormat() {
        assertTrue(VarUtils.isValidFormat("yyyy-MM-dd", "2019-01-01"));
        assertFalse(VarUtils.isValidFormat("yyyy-MM-dd", "01/01/2019"));
        assertFalse(VarUtils.isValidFormat("yyyy-MM-dd", "2019"));

    }

    @Test
    public void parseDateYYYYMMDD() {

        Date expectedDate = new GregorianCalendar(2019, 00, 01).getTime();

        assertEquals(expectedDate, VarUtils.parseDateYYYYMMDD("2019-01-01"));
        assertEquals(null, VarUtils.parseDateYYYYMMDD("01/01/2019"));

    }

    @Test
    public void findTheNthPercentile() {
        assertEquals(11, VarUtils.findTheNthPercentile(12, 95));
        assertEquals(10, VarUtils.findTheNthPercentile(12, 84));
        assertEquals(0, VarUtils.findTheNthPercentile(0, 84));

    }

    @Test
    public void getXdaysBefore() {
        Date mockedDate = new GregorianCalendar(2019, Calendar.JANUARY, 11).getTime();
        Date expectedDate = new GregorianCalendar(2019, Calendar.JANUARY, 01).getTime();

        assertEquals(expectedDate, VarUtils.getXdaysBefore(mockedDate, 10));
        assertEquals(mockedDate, VarUtils.getXdaysBefore(mockedDate, 0));
    }
}
