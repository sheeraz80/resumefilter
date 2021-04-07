package com.resumes.submission.transformers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class PuzzleRequestTransformer implements StringTransformer {
    protected static final Pattern PATTERN = Pattern.compile(" ABCD(.+)", Pattern.DOTALL);

    @Override
    public String transform(String input) {
        Matcher matcher = PATTERN.matcher(input);
        boolean match = matcher.find();
        return matcher.group(1).replaceAll("\n", "");
    }
}