package com.cafrecode.lib.am2v;

import com.cafrecode.lib.am2v.annotations.Capitalize;
import com.cafrecode.lib.am2v.annotations.ExtractedName;
import com.cafrecode.lib.am2v.annotations.IgnoreExtraction;
import com.cafrecode.lib.am2v.annotations.Index;
import com.cafrecode.lib.am2v.annotations.MeasurementUnit;
import com.cafrecode.lib.am2v.annotations.Ordered;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FieldsUtil {

    public static List<Result> getFieldValuePairs(Object obj) throws IllegalAccessException {

        List<Result> results = new ArrayList<>();

        //now we don't have kotlin's type safety, meh!
        if (obj == null) {
            return results;
        }
        Class<? extends Object> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();

        //determine if class be ordered then do the ordering before proceeding

        boolean isOrdered = clazz.isAnnotationPresent(Ordered.class);

        if (isOrdered) {
            sort(fields);
        }

        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            fields[i].setAccessible(true);

            boolean ignored = fields[i].isAnnotationPresent(IgnoreExtraction.class);
            boolean capitalize = fields[i].isAnnotationPresent(Capitalize.class);
            boolean customName = fields[i].isAnnotationPresent(ExtractedName.class);
            boolean withUnit = fields[i].isAnnotationPresent(MeasurementUnit.class);

            Object value = fields[i].get(obj);


            if (!ignored) {

                String title = toTitleCase(splitCamelCase(name));

                if (value == null) {
                    value = "0";
                } else {
                    value = fields[i].get(obj).toString();
                }
                if (capitalize) {
                    title = title.toUpperCase(Locale.ENGLISH);
                }
                if (customName) {
                    title = fields[i].getAnnotation(ExtractedName.class).name();
                }
                if (withUnit) {
                    value = value + " " + fields[i].getAnnotation(MeasurementUnit.class).name();
                }
                results.add(new Result(title + ":", value.toString()));
            }
        }

        return results;
    }

    public static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

    public static String toTitleCase(String input) {

        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }
        return titleCase.toString();
    }

    private static void sort(Field[] fields) {

        Arrays.sort(fields, (o1, o2) -> {
            Index or1 = o1.getAnnotation(Index.class);
            Index or2 = o2.getAnnotation(Index.class);
            // nulls last
            if (or1 != null && or2 != null) {
                return or1.value() - or2.value();
            } else if (or1 != null && or2 == null) {
                return -1;
            } else if (or1 == null && or2 != null) {
                return 1;
            }
            return o1.getName().compareTo(o2.getName());
        });
    }
}
