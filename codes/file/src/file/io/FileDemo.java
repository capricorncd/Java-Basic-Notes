package file.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// �˽⹹�캯�������
		File file = new File("D:\\java\\test");
		System.out.println("�ļ��Ƿ���ڣ�" + (file.exists() ? "��" : "��"));
		// �������ļ���Ŀ¼������
		if (!file.exists()) {
			file.mkdir();
			// �༶Ŀ¼����
			//file.mkdirs();
		} else {
			file.delete();
		}
		// ��Ŀ¼��Ŀ¼���ڷ���true�����򷵻�false
		System.out.println("�Ƿ�ΪĿ¼��" + file.isDirectory());
		System.out.println("�Ƿ�Ϊ�ļ���" + file.isFile());
		System.out.println();
		
//		File file2 = new File("D:\\java\\test.txt");
		File file2 = new File("D:\\java", "test.txt");
		if (!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			file2.delete();
		}
		
		System.out.println(file);//D:\java\test
		System.out.println(file.getAbsolutePath());//D:\java\test
		System.out.println(file.getParent());//D:\java
		System.out.println(file.getName());//test
		System.out.println();
		
		System.out.println(file2.getParent());//D:\java
		System.out.println(file2.getName()); //test.txt
	}

}
