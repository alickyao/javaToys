package toysExcption;

import java.io.*;

public class TestExcption {
	public static void main(String[] args){
		
		//String separator = File.separator;//File类中有一个静态常量 代表了当前系统的路径分隔符
		
		String path = "files/";//这里需要用/表示机器上的一个路径，因为JAVA可以跨平台，所以不要使用\\来作为路径的分隔符
		String filename = "test.txt";
		
		File dir = new File(path);
		if (!dir.exists()){
			System.out.println("文件夹不存在，创建一个文件夹");
			dir.mkdirs();
		}
		else{
			System.out.println("文件夹已经存在");
		}
		File file = new File(path+filename);
		if (file.exists()){
			System.out.println("文件存在");
			System.out.println(file.getName());
			file.delete();
		}
		else{
			System.out.println("文件不存在");
			try {
				file.createNewFile();//执行当前操作可能会抛出IOException异常 必须用try catch 捕捉，否则需要在方法中声明抛出异常
				System.out.println("创建文件成功");
			} catch (IOException e) {//file.createNewFile();可能会抛出IOException异常
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//throw new MyException("文件不可读取", 123);
		}
		
		//必须捕捉TestExcaptionClass.getException();的两个异常
		try {
			TestExcaptionClass.getException();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class TestExcaptionClass{
	
	//抛出异常不处理，则要在方法的声明中 说明要抛出的异常的类型
	static void getException() throws MyException, IOException{
		File file = new File("files/aa.txt");
		file.createNewFile();//执行当前操作可能会抛出IOException异常
		throw new MyException("我自己抛出的异常", 564);//必定会抛出MyException异常
	}
}


//异常是可以自定义的，自定义一个异常类 继承自 Exception
class MyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public MyException(String message,int id) {
		// TODO Auto-generated constructor stub
		super(message);
		this.id = id;
	}
	int getId(){
		return this.id;
	}
}
