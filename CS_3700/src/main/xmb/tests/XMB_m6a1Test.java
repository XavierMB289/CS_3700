package main.xmb.tests;

import org.junit.jupiter.api.Test;

import main.xmb.XMB_m6a1;

class XMB_m6a1Test {

	@Test
	void test() {
		assert XMB_m6a1.Calc(new int[] {0, 3, 6}) == 3f;
		assert XMB_m6a1.Calc(new int[] {0, 50, 100, 150}) == 75f;
		assert XMB_m6a1.Calc(new int[] {3, 3, 3, 3, 7, 7, 4}) != Math.PI;
	}

}
