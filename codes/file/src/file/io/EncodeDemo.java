package file.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "��������ABC";
		
		/**
		 * �ַ���תbyte[]
		 */
		// ת�����ֽ��������õ�����ĿĬ�ϵı���GBK������ռ�����ֽ�
		byte[] bytes1 = s.getBytes();
		for (byte b : bytes1) {
			// ���ֽڣ�ת������int����16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// �����c4 fa ba c3 ca c0 bd e7 41 42 43 
		System.out.println("");
		
		byte[] bytes2 = s.getBytes("GBK");
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// �����c4 fa ba c3 ca c0 bd e7 41 42 43 
		// GBK��������ռ2���ֽڣ�Ӣ��ռ1���ֽ�
		System.out.println("");
		
		// utf-8
		byte[] bytes3 = s.getBytes("utf-8");
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// �����e6 82 a8 e5 a5 bd e4 b8 96 e7 95 8c 41 42 43 
		// utf-8��������ռ3���ֽڣ�Ӣ��ռ1���ֽ�
		System.out.println("");
		
		// Java��˫�ֽڱ���utf-16be
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// �����60 a8 59 7d 4e 16 75 4c 0 41 0 42 0 43 
		// utf-16be����ռ2���ֽڣ�Ӣ��ռ��2���ֽ�
		System.out.println("");
		
		/**
		 * byte[]ת�ַ���
		 * ���ֽ�����Ϊĳ�ֱ���ʱ�����ʱ������ֽ����б���ַ�����
		 * Ҳ��Ҫ�����ֱ��뷽ʽ��������������
		 */
		// ����ĿĬ�ϵı���
		String str1 = new String(bytes1);
		System.out.println(str1);
		String str2 = new String(bytes2, "GBK");
		System.out.println(str2);
		String str3 = new String(bytes3, "utf-8");
		System.out.println(str3);
		String str4 = new String(bytes4, "utf-16be");
		System.out.println(str4);
		
		/**
		 * �ı��ļ� �����ֽ����У�
		 * �����ʹ���������ֽ�����
		 * *�����Ļ�����ֱ�Ӵ����ı��ļ������ļ�ֻ��ʶansi����
		 */
	}

}
