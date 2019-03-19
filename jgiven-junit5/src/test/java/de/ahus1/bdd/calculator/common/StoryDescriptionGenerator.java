package de.ahus1.bdd.calculator.common;

import com.tngtech.jgiven.annotation.TagDescriptionGenerator;
import com.tngtech.jgiven.config.TagConfiguration;

import java.lang.annotation.Annotation;

public class StoryDescriptionGenerator implements TagDescriptionGenerator {
    @Override
    public String generateDescription(TagConfiguration tagConfiguration,
                                      Annotation annotation, Object value) {
        return String.format("Story: %s", value, value);
    }
}
