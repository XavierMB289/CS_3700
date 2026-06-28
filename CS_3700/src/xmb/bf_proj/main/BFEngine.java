package xmb.bf_proj.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BFEngine {
	
	private final BFPointer pointer;
	private String bfCode;
	private final Consumer<Integer> outputFunction;
	private final Supplier<Integer> inputFunction;
	
	private BFLoopData loopData;
	
	public BFEngine(String relativeFilePath, Consumer<Integer> outputFun, Supplier<Integer> inputFun) {
		pointer = new BFPointer();
		bfCode = readCodeFromFile(relativeFilePath);
		outputFunction = outputFun;
		inputFunction = inputFun;
		loopData = new BFLoopData();
	}
	
	/**
	 * Executes the BrainFuck code that was loaded from the file.
	 */
	public void execute() {
		//Populating Pointers
		System.out.println("Locating Looping Pointers in BF CODE:");
		System.out.println(bfCode);
		for(int i = 0; i < bfCode.length(); i++) {
			char c = bfCode.charAt(i);
			if(c == '[') {
				loopData.addLoopStart(i);
			}else if(c == ']') {
				loopData.addLoopEnd(i);
			}
		}
		System.out.println("Found "+loopData.getPointerLen()+" Pointer Pairs");
		System.out.println("Executing Code...");
		//Executing Code
		int cIndex = 0;
		while(cIndex < bfCode.length()) {
			char c = bfCode.charAt(cIndex);
			switch(c) {
				case '>': //Moving Right
					pointer.moveRight();
					break;
				case '<': //Moving Left
					pointer.moveLeft();
					break;
				case '+': //Increment % 256
					pointer.increment();
					break;
				case '-': //Decrement
					pointer.decrement();
					break;
				case '.': //Output
					outputFunction.accept(pointer.getDataAtPointer());
					break;
				case ',': //Input
					pointer.input(inputFunction.get());
					break;
				case '[': //Start Loop
					if(pointer.getDataAtPointer() == 0) {
						cIndex = loopData.getLoopEnd(cIndex);
					}
					break;
				case ']': //End Loop
					if(pointer.getDataAtPointer() > 0) {
						cIndex = loopData.getLoopStart(cIndex);
					}
					break;
			}
			cIndex++;
		}
		System.out.println("Interpretation Complete");
	}
	
	/**
	 * Calls the pointer.toString() and prints it.
	 */
	public void printCurrentData() {
		System.out.println(pointer.toString());
	}
	
	/**
	 * Reads ONLY BrainFuck code from a file.
	 * @param relativeFilePath Relative path to the code.
	 * @return the BrainFuck code
	 */
	private String readCodeFromFile(String relativeFilePath) {
		String ret = "";
		File file = new File(relativeFilePath);
		
		System.out.println("Working Filepath: "+Paths.get("").toAbsolutePath().toString());
		
		try (Scanner scan = new Scanner(file)){
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				for(char c : line.toCharArray()) {
					if("><+-.,[]".contains(c+"")) {
						ret+=c;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
			e.printStackTrace();
		}
		return ret;
	}
	
}
