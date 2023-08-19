package br.tech.ada.stock.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Slf4j
public class Utils {
    public static String downloadToString(String url) throws IOException {
        InputStream in = URI.create(url).toURL().openStream();
        String text = null;
        try (Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        }
        log.info(text);
        return text;
    }

}
