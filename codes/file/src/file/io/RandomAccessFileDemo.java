package file.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		File demo = new File("D:\\java\\demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// ָ���λ��
		System.out.println(raf.getFilePointer());
		// write����ÿ��ֻ��дһ���ֽ�
		raf.write('A');
		System.out.println(raf.getFilePointer());
		raf.write('B');
		
		int num = 0x7fffffff;
		// write����ÿ��ֻ��дһ���ֽڣ������numд��ȥ�͵�д4��
		raf.write(num >>> 24);
		raf.write(num >>> 16);
		raf.write(num >>> 8);
		raf.write(num);
		
		//����ֱ��д��һ��int
		raf.writeInt(num);
		
		String s = "��";
		byte[] gbk = s.getBytes("GBK");
		raf.write(gbk);
		System.out.println(raf.length());
		
		// ���ļ�����ָ���Ƶ�ͷ��
		raf.seek(0);
		//һ���Զ�ȡ�����ļ��е����ݣ���ȡ���ֽ�������
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		
		System.out.println(Arrays.toString(buf));
		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		raf.close();
	}

}
