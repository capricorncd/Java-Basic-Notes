package file.io;

import java.io.File;
import java.io.IOException;

/**
 * ʵ��File��һЩ���ò�����������ˡ�������
 * @author capricorncd
 *
 */
public class FileUtils {	
	/**
	 * �г�ָ��Ŀ¼�µ������ļ������ļ��У���������Ŀ¼��
	 * @param dir
	 * @param deep
	 */
	public static void printListDirectory(File dir, boolean deep) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼�����ڣ�" + dir);
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + ", ����Ŀ¼");
		}
		//����Ŀ¼�µ������ļ�����Ŀ¼������Ŀ¼�������ļ���Ŀ¼
		if (deep) {
			File[] files = dir.listFiles();
			if (files != null && files.length > 0) {
				for (File f : files) {
					if (f.isDirectory()) {
						printListDirectory(f, true);
					} else {
						System.out.println(f);
					}
				}
			}
		}
		//����Ŀ¼�µ��ļ�����Ŀ¼���ƣ���������Ŀ¼�µ�����
		else {
			String[] fileNames = dir.list();
			for (String str : fileNames) {
				System.out.println(dir + "\\" + str);
			}
		}
	}
}
