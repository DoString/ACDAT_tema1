package com.example.hola_;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Hash {
	private final static String SHA1 = "SHA1";
	private final static String HMACSHA1 = "HmacSHA1";
	
	public static String ComputarSha1 (String datos) throws NoSuchAlgorithmException{
		MessageDigest me = MessageDigest.getInstance(SHA1);
		
		byte[] bytes = me.digest(datos.getBytes());
		StringBuffer sr = new StringBuffer();
		
		for (byte b : bytes) {
			sr.append(String.format("%02x", b));
		}		
		return sr.toString();
	}
	
	public static String ComputarHmacSha1 (String clave, String datos) throws NoSuchAlgorithmException, InvalidKeyException{
		Mac mac = Mac.getInstance(HMACSHA1);
		byte[] key = clave.getBytes();
		byte[] dat = datos.getBytes();
		mac.init(new SecretKeySpec(key, HMACSHA1));
		byte[] res = mac.doFinal(dat);
		
		StringBuffer sr = new StringBuffer();
		for (byte b : res) {
			sr.append(String.format("%02x", b));
		}
		return sr.toString();
	}
	
	public static String Capitalizado (String hash){
		return String.format("%S", hash);
	}
	///
	public static String LockDown (String hash) {
		if (hash.length() != 40) return "ERROR: la longitud del hash debe ser 20 bytes";
		int hashLen = hash.length() - 1;
		int cuenta = 0;
		StringBuffer sr = new StringBuffer();
		// Creamos una pila LIFO:
		Stack<String> pila = new Stack<String>();
		
		//Invertimos el orden de los bytes cada bloque de 4 utilizando la pila:
		String str = "";
		while (cuenta <= hashLen) {
			int i = 0;
			while (i <= 7) {
				str += hash.charAt(cuenta);
				if ((i+1)%2==0){
					pila.push(str);
					str = "";
				}
				i++;cuenta++;
			}
			int k = 0;
			while (k <= 3){
				sr.append(pila.pop());
				k++;
			}
		}
		return sr.toString();
	}
}
