package xmb.bf_proj.testing;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import xmb.bf_proj.main.BFEngine;

public class BF_Test {
	
	@Test
	void Test() {
		//First Test
		BFEngine engine = new BFEngine(
			"src/xmb/bf_proj/BF_CODE/Hello_World.bf",
			new Consumer<Integer>() {
				@Override
				public void accept(Integer t) {
					System.out.print((char)((int)t));
				}
			},
			new Supplier<Integer>() {

				@Override
				public Integer get() {
					return -1;
				}
				
			}
		);
		engine.execute();
		//MAKE SURE IT PRINTS "Hello World!"
	}
	
}
