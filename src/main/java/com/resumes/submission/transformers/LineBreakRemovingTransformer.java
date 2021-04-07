package com.resumes.submission.transformers;

import org.springframework.stereotype.Controller;

@Controller
public class LineBreakRemovingTransformer  implements StringTransformer{
    @Override
    public String transform(String input) {
        return input.replace("\n", "").replace("\r", "");
    }
}