package com.git.intergration.utils;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.expression.ParseException;

public class Utils {

	public static String convertToNewFormat(String dateStr) throws ParseException {
		Instant instant = Instant.parse(dateStr);
		OffsetDateTime odt = instant.atOffset(ZoneOffset.UTC);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
		String output = odt.format(f);
		return output;
	}

}
