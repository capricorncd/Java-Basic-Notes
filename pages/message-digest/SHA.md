# 消息摘要算法--SHA

SHA(Secure Hash Algorithm) **安全散列算法**的简称。

固定长度摘要信息

### SHA-1, SHA-2(SHA-224, SHA-256, SHA-384, SHA-512)

|算法|摘要长度|实现方法|
|:--|:--|:--|
|SHA-1|160|JDK|
|SHA-224|224|Bouncy Castle/JDK1.8|
|SHA-256|256|JDK|
|SHA-384|384|JDK|
|SHA-512|512|JDK|

### 代码实现

```java
package md.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;

/**
 * Secure Hash Algorithm
 * @author Capricorncd
 * https://github.com/capricorncd
 */
public class TestSHA {

	private static final String SHA = "SHA";
	private static final String SHA_224 = "SHA-224";
	private static final String SHA_256 = "SHA-256";
	private static final String SHA_384 = "SHA-384";
	private static final String SHA_512 = "SHA-512";

	public static void main(String[] args) {
		String src = "Test Secure Hash Algorithm.";
		// JDK
		jdkSHA(src, SHA);
		jdkSHA(src, SHA_224);
		jdkSHA(src, SHA_256);
		jdkSHA(src, SHA_384);
		jdkSHA(src, SHA_512);
		// Bouncy Castle
		println("");
		bcSHA(src, SHA, new SHA1Digest());
		bcSHA(src, SHA_224, new SHA224Digest());
		bcSHA(src, SHA_256, new SHA256Digest());
		bcSHA(src, SHA_384, new SHA384Digest());
		bcSHA(src, SHA_512, new SHA512Digest());
		// org.apache.commons.codec.digest.DigestUtils
		println("");
		ccSHA(src, SHA);
		ccSHA(src, SHA_224);
		ccSHA(src, SHA_256);
		ccSHA(src, SHA_384);
		ccSHA(src, SHA_512);
	}

	/**
	 * JDK SHA
	 * @param src source
	 * @param algorithm algorithm type
	 */
	public static void jdkSHA(String src, String algorithm) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] mdBytes = md.digest(src.getBytes());
			result = Hex.encodeHexString(mdBytes);
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			result = e.getMessage();
		}
		println(algorithm + ":", result, "by JDK");
	}

	/**
	 * Bouncy Castle SHA
	 * @param <T> Digest
	 * @param src source
	 * @param algorithm
	 * @param digest Digest
	 */
	public static<T extends Digest> void bcSHA(String src, String algorithm, T digest) {
		// input bytes
		byte[] srcBytes = src.getBytes();
		digest.update(srcBytes, 0, srcBytes.length);
		// result bytes
		byte[] resBytes = new byte[digest.getDigestSize()];
		digest.doFinal(resBytes, 0);
		// to Hex
		String result = org.bouncycastle.util.encoders.Hex.toHexString(resBytes);
		println(algorithm + ":", result, "by Bouncy Castle");
	}

	/**
	 * org.apache.commons.codec.digest.DigestUtils
	 * @param src
	 * @param algorithm
	 */
	public static void ccSHA(String src, String algorithm) {
		String result = null;
		try {
			switch(algorithm) {
			case SHA:
				result = DigestUtils.sha1Hex(src);
				break;
			case SHA_224:
				result = DigestUtils.sha3_224Hex(src);
				break;
			case SHA_256:
				result = DigestUtils.sha256Hex(src);
				break;
			case SHA_384:
				result = DigestUtils.sha384Hex(src);
				break;
			case SHA_512:
				result = DigestUtils.sha512Hex(src);
				break;
			}
		} catch (Exception e) {
			result = e.getMessage();
		}
		println(algorithm + ":", result, "by org.apache.commons.codec.digest.DigestUtils");
	}

	/**
	 * System.out.println
	 * @param args
	 */
	public static void println(Object ...args) {
		for (Object o : args) {
			System.out.print(o + " ");
		}		
		System.out.print("\n");
	}
}
```

运行结果：

```
SHA: 1ec4fe70c8223dbf362dd02481d2abe032aeaa23 by JDK
SHA-224: 7ce9d2ecd24444271fd823c8ded2931fa35ae70c747350004bce6291 by JDK
SHA-256: fc0de412e726341a95ae30b8ede3dfbb502fa50f9532439e45ca86cdfa725489 by JDK
SHA-384: 75cd6f06373ff58d7f50d02a68116108d1c56761e401f20dda6a3fa863b477bb2ce2030d8c760bf9da228d4623262273 by JDK
SHA-512: 9e9b3e31616ac90d2ec9981a2ba05c2045af58af9c279aa5d9fc45248982fe4eafaeccc12270310c2819b5b8b7541f5d9ba884bfac1b3c3fdfe8c42adb283643 by JDK

SHA: 1ec4fe70c8223dbf362dd02481d2abe032aeaa23 by Bouncy Castle
SHA-224: 7ce9d2ecd24444271fd823c8ded2931fa35ae70c747350004bce6291 by Bouncy Castle
SHA-256: fc0de412e726341a95ae30b8ede3dfbb502fa50f9532439e45ca86cdfa725489 by Bouncy Castle
SHA-384: 75cd6f06373ff58d7f50d02a68116108d1c56761e401f20dda6a3fa863b477bb2ce2030d8c760bf9da228d4623262273 by Bouncy Castle
SHA-512: 9e9b3e31616ac90d2ec9981a2ba05c2045af58af9c279aa5d9fc45248982fe4eafaeccc12270310c2819b5b8b7541f5d9ba884bfac1b3c3fdfe8c42adb283643 by Bouncy Castle

SHA: 1ec4fe70c8223dbf362dd02481d2abe032aeaa23 by org.apache.commons.codec.digest.DigestUtils
SHA-224: java.security.NoSuchAlgorithmException: SHA3-224 MessageDigest not available by org.apache.commons.codec.digest.DigestUtils
SHA-256: fc0de412e726341a95ae30b8ede3dfbb502fa50f9532439e45ca86cdfa725489 by org.apache.commons.codec.digest.DigestUtils
SHA-384: 75cd6f06373ff58d7f50d02a68116108d1c56761e401f20dda6a3fa863b477bb2ce2030d8c760bf9da228d4623262273 by org.apache.commons.codec.digest.DigestUtils
SHA-512: 9e9b3e31616ac90d2ec9981a2ba05c2045af58af9c279aa5d9fc45248982fe4eafaeccc12270310c2819b5b8b7541f5d9ba884bfac1b3c3fdfe8c42adb283643 by org.apache.commons.codec.digest.DigestUtils
```

### SHA-应用

![secure-hash-algorithm-certificate](./img/secure-hash-algorithm-certificate.png)

加入约定key，增加时间戳，排序

```
https://*?msg=f58d7f50d02a...16&timestamp=1590324555411
```

```
msg: 原始消息+key+时间戳
```

![secure-hash-algorithm](./img/secure-hash-algorithm.png)
