package com.app.demo.Gof23Model.lsp.section6;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Client {
	public static void invoker(){
		//父类存在的地方，子类就应该能够存在
		//Father f = new Father();
		Son f =new Son();
		Map map = new HashMap();
		Collection arrayList = f.doSomething(map);
	}
	
	public static void main(String[] args) {
		
		invoker();
	}
}
