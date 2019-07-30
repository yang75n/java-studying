package com.yqw.java.proxy.staticProxy;
public class Client {

	public static void main(String[] args){
		//UserManager userManager=new UserManagerImpl();
		UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());
		userManager.addUser("1111", "张三");
	}
}