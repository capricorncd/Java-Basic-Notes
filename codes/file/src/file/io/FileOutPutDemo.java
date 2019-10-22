package file.io;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;

public class FileOutPutDemo {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\java\\temp\\out.dat";
		// ����ļ������ڣ���ֱ�Ӵ�����������ڣ�ɾ�����ٴ���
		// #���еڶ���������true���ļ���׷������
		FileOutputStream out = new FileOutputStream(filePath);
		// д����A�ĵ�8λ
		out.write('A');
		// д����B�ĵ�8λ
		out.write('B');
		// writeֻ��д8λ����дһ��int��Ҫд4��
		int a = 10;
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		
		byte[] gbk = "�й�".getBytes("GBK");
		out.write(gbk);
		out.close();
		
		IOUtils.printHex(filePath);
		
		File destFile = new File("D:\\java\\temp\\copy.txt");
		
		IOUtils.fileCopy(new File(filePath), destFile);
	}

}
