package edu.ifsp.ged.commons.utils.encrypt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import edu.ifsp.ged.commons.utils.Utils;

public class EncrypterHandlerRSA {

	public static void main(String[] args) {

		Base64.Encoder encoder = Base64.getEncoder();
//		Base64.Decoder decoder = Base64.getDecoder();

		String TextStream = "this is the input text";
		byte[] Cipher;
		System.out.println("input:\n" + TextStream);
		Cipher = encrypt(TextStream,Utils.PUBLIC_KEY);
		System.out.println("cipher:\n" + encoder.encodeToString(Cipher));		
		System.out.println("decrypt:\n" + decrypt(Cipher, Utils.PRIVATE_KEY));
	}

	public static byte[] encrypt(String Buffer,String publicKey) {
		try {
			Cipher rsa;
			rsa = Cipher.getInstance("RSA");
			rsa.init(Cipher.ENCRYPT_MODE, getPublic(publicKey));
			return rsa.doFinal(Buffer.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(byte[] buffer,String privateKey) {
		try {
			Cipher rsa;
			rsa = Cipher.getInstance("RSA");
			rsa.init(Cipher.DECRYPT_MODE, getPrivate(privateKey));
			byte[] utf8 = rsa.doFinal(buffer);
			return new String(utf8, "UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PrivateKey getPrivate(String filename) throws Exception {

		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	public static PublicKey getPublic(String filename) throws Exception {

		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();

		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}
}
