package FileWriteRead;

import java.io.FileInputStream;
import java.io.IOException;

public class FileRead1 {
	public static void main(String[] args) throws IOException  {
		byte[] b = new byte[1024]; // 1kb
		FileInputStream input = new FileInputStream("out1.txt");
		input.read(b);
		System.out.println(new String(b));
		input.close();		
	}
}
