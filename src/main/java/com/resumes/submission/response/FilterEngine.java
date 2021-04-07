package com.resumes.submission.response;

import java.util.HashMap;
import java.util.Map;

public class FilterEngine {
	public static Map<String, String> answersMap;
	static {
	    answersMap = new HashMap<>();
	    answersMap.put("Ping", "OK");
	    answersMap.put("Years", "18");
	    answersMap.put("Email Address", "sheeraz80@gmail.com");
	    answersMap.put("Referrer", "Recruiter - Andrew Rogers");
	    answersMap.put("Status", "Yes");
	    answersMap.put("Phone", "(973)405-3685");
	    answersMap.put("Position", "Senior/Staff Software Engineer - Applications");
	    answersMap.put("Source", "https://github.com/sheeraz80/resumefilter.git");
	    answersMap.put("Resume", "https://github.com/sheeraz80/resumefilter.git/static/ResumeSheerazAliN.pdf");
	    answersMap.put("Degree", "Masters in Computer Science");
	    answersMap.put("Name", "Sheeraz Ali");
	}
	
	/*
	 * Puzzle is solved using array matrix following below rules.
	 * 1. Row x Column matrix is created for ABCD elements.
	 * 2. Cross matrix with same row and column i.e. 1x1 or BxB will be '=' value.
	 * 3. If the input contains '<' i.e. A--<- then row will be filled with < .
	 *    and column with > for empty values.
	 * 4. If the input contains '=' i.e. B--=- then row will be filled with <
	 *     and column with > for empty values.
	 * 5. If the input contains '>' i.e. C---> then check the input position of '>' in solvedPuzzle.
	 *    If empty then fill with '<' and last remaining element with '>' otherwise switch previous 
	 *    logic.
	 * 
	 * */
	public static String solvePuzzle(String[] puzzleInput) {
		//2 Elements having '>' in ABCD
		int gt1=-1,gt2=-1;
		for(int i=0;i<puzzleInput.length;i++) {
			if(puzzleInput[i].contains(">")) {
				if(gt1>=0) {
					gt2=i;
				}
				else {
					gt1=i;
				}
			}
		}
		
		char[][] solvedPuzzle = new char[puzzleInput.length][puzzleInput.length];
		//Same Row x Column i.e. BxB or 1X1 is always equal 
		for(int i=0;i<puzzleInput.length;i++) {
			solvedPuzzle[i][i]='=';
		}
		
		if(puzzleInput[0].contains("<")) {
			solvedPuzzle[0][1] = solvedPuzzle[0][2] = solvedPuzzle[0][3] = '<';
			solvedPuzzle[1][0] = solvedPuzzle[2][0] = solvedPuzzle[3][0] = '>';
		}
		else if(puzzleInput[1].contains("<")) {
			solvedPuzzle[1][0] = solvedPuzzle[1][2] = solvedPuzzle[1][3] = '<';
			solvedPuzzle[0][1] = solvedPuzzle[2][1] = solvedPuzzle[3][1] = '>';
		}
		else if(puzzleInput[2].contains("<")) {
			solvedPuzzle[2][0] = solvedPuzzle[2][1] = solvedPuzzle[2][3] = '<';
			solvedPuzzle[0][2] = solvedPuzzle[1][2] = solvedPuzzle[3][2] = '>';
		}
		else if(puzzleInput[3].contains("<")) {
			solvedPuzzle[3][0] = solvedPuzzle[3][1] = solvedPuzzle[3][2] = '<';
			solvedPuzzle[0][3] = solvedPuzzle[1][3] = solvedPuzzle[2][3] = '>';
		}
		
		if(puzzleInput[0].contains("=")) {
			
			solvedPuzzle[0][gt1] = solvedPuzzle[0][gt2] = '<';
			solvedPuzzle[gt1][0] = solvedPuzzle[gt2][0] = '>';
		}
		else if(puzzleInput[1].contains("=")) {
			solvedPuzzle[1][gt1] = solvedPuzzle[1][gt2] = '<';
			solvedPuzzle[gt1][1] = solvedPuzzle[gt2][1] = '>';
		}
		else if(puzzleInput[2].contains("=")) {
			solvedPuzzle[2][gt1] = solvedPuzzle[2][gt2] = '<';
			solvedPuzzle[gt1][2] = solvedPuzzle[gt2][2] = '>';
		}
		else if(puzzleInput[3].contains("=")) {
			solvedPuzzle[3][gt1] = solvedPuzzle[3][gt2] = '<';
			solvedPuzzle[gt1][3] = solvedPuzzle[gt2][3] = '>';
		}
		
		//position of '>' in 2 of the elements in ABCD		
		int pos1 = puzzleInput[gt1].indexOf(">")-1;
		int pos2 = puzzleInput[gt2].indexOf(">")-1;
		
		if(solvedPuzzle[gt1][pos1]=='\u0000') {
			solvedPuzzle[gt1][pos1] = '>';
			solvedPuzzle[pos1][gt1] = '<';
		}
		else {
				solvedPuzzle[gt2][pos2] = '>';
				solvedPuzzle[pos2][gt2] = '<';
		}
		
		
		StringBuilder sb = new StringBuilder("  ABCD\n");
		
		char element ='A';
		for(int i=0;i<solvedPuzzle.length;i++) {
			sb.append(element++); //will give B, C and D after incrementing char A
			for(int j=0;j<solvedPuzzle[0].length;j++) {
				sb.append( solvedPuzzle[i][j] = solvedPuzzle[i][j] );
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
