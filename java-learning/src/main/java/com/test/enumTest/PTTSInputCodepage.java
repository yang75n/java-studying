package com.test.enumTest;

public enum PTTSInputCodepage {

	PTTS_CODEPAGE_ASCII, // ASCII
	PTTS_CODEPAGE_GBK, // GBK (default)
	PTTS_CODEPAGE_BIG5, // Big5
	PTTS_CODEPAGE_UTF8, // UTF-8
	PTTS_CODEPAGE_UTF16, // UTF-16 little endian
	PTTS_CODEPAGE_UTF16BE, // UTF-16 big endian
	PTTS_CODEPAGE_UTF16LE(PTTS_CODEPAGE_UTF16.ordinal()), PTTS_CODEPAGE_GB2312, PTTS_CODEPAGE_GB18030;

	public final int code;

	private PTTSInputCodepage(int code) {
		this.code = code;
	}

	private PTTSInputCodepage() {
		code =ordinal();
	}

	public static void main(String[] args) {
		System.out.println(PTTS_CODEPAGE_ASCII.code);
		System.out.println(PTTS_CODEPAGE_GB2312.code);
		System.out.println(PTTS_CODEPAGE_UTF16LE.code);
		System.out.println(PTTS_CODEPAGE_UTF16LE.ordinal());
	}

}
