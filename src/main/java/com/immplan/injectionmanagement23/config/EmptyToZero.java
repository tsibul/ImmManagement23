package com.immplan.injectionmanagement23.config;
import org.springframework.core.convert.converter.Converter;

public class EmptyToZero {

    public static class StringToIntegerConverter implements Converter<String, Integer> {
        @Override
        public Integer convert(String source) {
            if (source.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(source);
        }
    }

    public static class StringToDoubleConverter implements Converter<String, Double> {
        @Override
        public Double convert(String source) {
            if (source.isEmpty()) {
                return 0.0;
            }
            return Double.parseDouble(source);
        }
    }

    public static class StringToFloatConverter implements Converter<String, Float> {
        @Override
        public Float convert(String source) {
            if (source.isEmpty()) {
                return 0.0f;
            }
            return Float.parseFloat(source);
        }
    }
}
