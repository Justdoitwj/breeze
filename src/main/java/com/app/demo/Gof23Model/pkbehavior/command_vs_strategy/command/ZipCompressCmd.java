package com.app.demo.Gof23Model.pkbehavior.command_vs_strategy.command;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class ZipCompressCmd extends AbstractCmd {

	public boolean execute(String source,String to) {
		return super.compress.zipExec(source, to);
	}

}
