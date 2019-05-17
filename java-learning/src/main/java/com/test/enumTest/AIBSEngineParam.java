package com.test.enumTest;

public enum AIBSEngineParam {
	/** 文档注释 **/
	c(1, "sdf"),
	/*** 文档注释 ****/
	d(1, "sdfsd"), e(56, ""), f(234324, "");

	private AIBSEngineParam(int value, String _name) {
		this.value = value;
		this.name = _name;
	}

	public final int value;
	public final String name;

}
