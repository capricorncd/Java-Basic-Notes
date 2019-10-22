package file.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\java\\temp\\dos.dat";
		FileOutputStream fos = new FileOutputStream(filePath);
		DataOutputStream dos = new DataOutputStream(fos);
		// write
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		// ����utf-8�������
		dos.writeUTF("�й�");
		// ����utf-16be�������
		dos.writeChars("�й�");
		dos.close();
		
		IOUtils.printHex(filePath);
		System.out.println("\n");
		IOUtils.printHexByByteArray(filePath);
		System.out.println("\n");
		IOUtils.printHexByByteArray2(filePath);
	}

}
