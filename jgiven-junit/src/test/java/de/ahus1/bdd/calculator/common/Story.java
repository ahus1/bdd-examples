package de.ahus1.bdd.calculator.common;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag(descriptionGenerator = StoryDescriptionGenerator.class)
@Retention( RetentionPolicy.RUNTIME )
public @interface Story {
    String[] value();
}