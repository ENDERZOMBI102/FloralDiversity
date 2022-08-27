package com.enderzombi102.endconfig.api;

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Contains all the annotations for fields.
 */
public @interface ConfigOptions {

	/**
	 * Annotating a class with this will mark every field as needed to be synced to clients.
	 * Annotating a field will overwrite per-class Sync with the provided value.
	 */
	@Target({ ElementType.FIELD, ElementType.TYPE })
	@Retention( RetentionPolicy.RUNTIME )
	@interface Sync {
		boolean value() default true;
	}

	/**
	 *
	 */
	@Target( ElementType.FIELD )
	@Retention( RetentionPolicy.RUNTIME )
	@interface Tooltip {
		int value() default 1;
	}

	/**
	 *
	 */
	@Target( ElementType.FIELD )
	@Retention( RetentionPolicy.RUNTIME )
	@interface Range {
		double min();
		double max();
	}

	/**
	 * Will make a dropdown
	 */
	@Target({ ElementType.FIELD, ElementType.METHOD })
	@Retention( RetentionPolicy.RUNTIME )
	@interface Options {
		String[] value();
	}

	/**
	 * Sets the name of a enum value directly on the value.
	 */
	@Target(ElementType.FIELD)
	@Retention( RetentionPolicy.RUNTIME )
	@interface Name {
		String value();
	}

	/**
	 * Used to determine how a field's enum member instances should be named.
	 */
	@Target( ElementType.FIELD )
	@Retention( RetentionPolicy.RUNTIME )
	@ApiStatus.Experimental
	@interface RenamingPolicy {
		//  `named` = @Name("") annotations on enum values
		@Options({ "asis", "pascal", "snake", "named" })
		String value();
	}

	/**
	 * Fields marked with this annotation will not be picked up by the library.
	 */
	@Target( ElementType.FIELD )
	@Retention( RetentionPolicy.RUNTIME )
	@interface Ignore { }

	/**
	 * Will be used as comment in the config file.
	 */
	@Target( ElementType.FIELD )
	@Retention( RetentionPolicy.RUNTIME )
	@interface Comment {
		String value();
	}
}
