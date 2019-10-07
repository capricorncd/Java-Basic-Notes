package file.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IOUtils {
	private static final int LINE_NUM = 50; 
	/**
	 * ��ȡָ���ļ����ݣ�����16�������������̨
	 * ����ÿ���10��byte����
	 * @param fileName
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException {
		// ���ļ���Ϊ�ֽ������ж�ȡ����
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int count = 1;
		while((b = in.read()) != -1) {
			print(b, count++);
		}
		in.close();
	}
	
	/**
	 * printHexByByteArray
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName) throws IOException {
		File file = new File(fileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[(int)file.length()];
		// ��in��������ȡ�ֽڣ����뵽buf����ֽ�������
		// �ӵ�0��λ�ÿ�ʼ�ţ�����buf.length��
		// ���ص��Ƕ������ֽڵĸ���
		int bytes = in.read(buf, 0, buf.length);
		int count = 1;
		for (int i = 0; i < bytes; i++) {
			print(buf[i], count++);
		}
		in.close();
	}
	
	/**
	 * printHexByByteArray2
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray2(String fileName) throws IOException {
		File file = new File(fileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[(int)file.length()];
		int count = 1;
		int bytes = 0;
		while((bytes = in.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < bytes; i++) {
				print(buf[i], count++);
			}
		}
		in.close();
	}
	
	/**
	 * print
	 * @param b
	 * @param count
	 */
	private static void print(int b, int count) {
		// ��λ��ǰ��0����С��10����
		if (b <= 0xf) {
			System.out.print("0");
		}
		// & 0xff��byte����8λ��int����32λ��
		// Ϊ�˱�������ת������ͨ��&0xff����24λ����
		System.out.print(Integer.toHexString(b & 0xff) + " ");
		if (count % LINE_NUM == 0) {
			System.out.println();
		}
	}
}
