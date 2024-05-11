package com.mvi.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import com.mvi.utils.DateUtils;
import com.mvi.utils.RandomDataGenerator;
import com.mvi.utils.RandomDataTypeNames;

public class SpecialValueProcessor {
	private static final Map<String, Function<String, String>> SPECIAL_VALUE_PROCESSORS = new HashMap<>();

	static {
		SPECIAL_VALUE_PROCESSORS.put("City".toLowerCase(), SpecialValueProcessor::processCityValue);
		SPECIAL_VALUE_PROCESSORS.put("Date|YYMMddHHmmss".toLowerCase(), SpecialValueProcessor::processUENValue);
	}

	public static String processSpecialValue(String value) {
		return SPECIAL_VALUE_PROCESSORS.getOrDefault(value.toLowerCase(), s -> s).apply(value);
	}

	private static String processCityValue(String value) {
		return RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
	}

	private static String processUENValue(String value) {
		return DateUtils.getCurrentLocalDateTimeStamp(value.split("\\|")[1]+ RandomDataGenerator.getRandomNumber(3));
	}
}
