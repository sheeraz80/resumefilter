package com.resumes.submission.restservice;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resumes.submission.response.FilterEngine;

@RestController
public class ResumeController {

    @RequestMapping("/filter/**")
    public String filter(@RequestParam("q") String q, @RequestParam("d") String d) throws IOException {
    	if(q.equalsIgnoreCase("Puzzle")) {
    		String[] puzzleInput =  d.split("\n");
    		return FilterEngine.solvePuzzle(Arrays.copyOfRange(puzzleInput, 2, puzzleInput.length));
    	}
    	return FilterEngine.answersMap.get(q);
    }
    
}
