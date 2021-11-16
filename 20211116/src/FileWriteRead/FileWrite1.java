package FileWriteRead;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite1 {
	// 문자열로 저장
	public static void main(String[] args) throws IOException {
		FileWriter f = new FileWriter("out1.txt");
		f.write("1 번째입니다. \n");
		f.write("2 번째입니다. \n");
		f.write("3 번째입니다. \n");
		for(int i = 1; i <= 10; i++) {
			f.write(i+" 번째입니다.\n");
		}
		f.close();		
	}
}