package com.resumes.submission.transformers;

import org.springframework.stereotype.Component;

@Component
public class SpaceTransformer implements StringTransformer {
    @Override
    public String transform(String input) {
        return input.replace(" ", "_");
    }
}