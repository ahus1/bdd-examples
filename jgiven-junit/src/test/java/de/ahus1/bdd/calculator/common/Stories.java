package de.ahus1.bdd.calculator.common;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag(name = "Stories")
@Retention( RetentionPolicy.RUNTIME )
public @interface Stories { }