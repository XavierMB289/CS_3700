package xmb.bf_proj.main.interpret;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
	
	public Main() {
		Engine engine = new Engine();
	}
	
}

class Pointer{
	
	//Variable Declaration
	private int pointer = 0;
	private int[] data = new int[0];
	private String BFCode = "";
	
	private void increaseSize(int num) {
		data = Arrays.copyOf(data, data.length+num);
	}
	
	private void increaseSize() {
		increaseSize(1);
	}
	
	private String repeatStr(String s, int num) {
		String ret = "";
		for(int i = 0; i < num; i++) {
			ret += s;
		}
		return ret;
	}
	
	public void addToCode(String code) {
		BFCode += code;
	}
	
	public String getCode() {
		return BFCode;
	}
	
	public int getDataAtPointer() {
		return data[pointer];
	}
	
	public void setDataAtPointer(int num) {
		data[pointer] = num;
		data[pointer] %= 256;
	}
	
	public void moveTo(int index) {
		if(pointer == index) {return;}
		
		if(pointer > index) {
			addToCode(repeatStr("-",(pointer-index)));
		}else {
			increaseSize(index-pointer);
			addToCode(repeatStr("+",(index-pointer)));
		}
		pointer = index;
	}
	
	public int getLocation() {
		return pointer;
	}
	
	public String dataToStr() {
		String ret = "";
		for(int d : data) {
			ret += ""+d;
		}
		return ret;
	}
	
	public String codeToStr() {
		return BFCode;
	}
	
}

class Engine{
	
	ArrayList<Variable> vars;
	Pointer pointer;
	
	public Engine() {
		//Variable Setup
		vars = new ArrayList<Variable>();
		pointer = new Pointer();
		//Temp Variable Setup
		addVar("temp", 0);
		pointer.moveTo(1);
	}
	
	private void addVar(String name, int data) {
		if(name.equals("temp")) {throw new IllegalArgumentException("CANNOT HAVE TEMP AS A VARIABLE NAME");}
		vars.add(new Variable(
			name, data,
			pointer.getLocation()
		));
	}
	
	public void run() {
		try(Stream<String> lines = Files.lines(Paths.get("CODE_HERE"))){
			lines.forEach(new Consumer<String>() {
				@Override
				public void accept(String line) {
					if(line.contains(" ")) {
						String[] lineSpl = line.split(" ");
						switch(lineSpl[0]) {
							default: //Adding a variable
								//TODO: THIS!
								//Had to stop due to cat.
						}
					}else {
						//TODO: THIS!
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

class Variable{
	
	private final String name;
	private int data;
	private final int location;
	
	public Variable(String name, int data, int location) {
		this.name = name;
		this.data = data;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int d) {
		data = d;
	}
	
	public int getLocation() {
		return location;
	}
	
}