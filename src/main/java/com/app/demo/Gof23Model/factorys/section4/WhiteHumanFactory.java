package com.app.demo.Gof23Model.factorys.section4;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class WhiteHumanFactory extends AbstractHumanFactory {

	public Human createHuman() {
		return new YellowHuman();
	}
}