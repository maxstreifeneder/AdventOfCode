package com.streifeneder.max.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * AdventOfCodeBase
 */
public class AdventOfCodeHelper {

    private static Class<?> caller;
    static {
        caller = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
    }

    public static Stream<String> getLinesOfFile() throws IOException {

        ClassLoader classLoader = caller.getClassLoader();
        File file = new File(classLoader.getResource(getCaller() + ".input").getFile());
        return Files.lines(file.toPath());
    }

    public static String getFileAsString() throws IOException {

        ClassLoader classLoader = caller.getClassLoader();
        File file = new File(classLoader.getResource(getCaller() + ".input").getFile());
        return Files.readString(file.toPath());
    }

    public static String getCaller() {
        return caller.getSimpleName().toLowerCase();

    }

}