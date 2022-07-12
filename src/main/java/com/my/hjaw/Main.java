package com.my.hjaw;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.NoSuchElementException;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private static final String CHARSET_NAME = "UTF-8";

    private static final Scanner SCANNER = new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME);

    @Override
    public void run(String... strings) {
        System.out.println("please input an integer...");
        String s = readString();
        int i = Integer.parseInt(s);

        System.out.println("the result is: " + new StairsMore().count(i));
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.setWebEnvironment(false);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    public static String readString() {
        try {
            return SCANNER.next();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'String' value from standard input, " + "but no more tokens are available");
        }
    }
}
