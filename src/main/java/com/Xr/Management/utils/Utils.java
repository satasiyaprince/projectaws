package com.Xr.Management.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.io.FilenameUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import com.Xr.Management.security.UserPrincipal;



public class Utils {

	/**
	 * This method is used to generate otp.
	 * 
	 * @return generated otp.
	 */
	public static int getOtp() {
		return new Random().nextInt(900000) + 100000;
	}

	/**
	 * This method use to get salt for create hash password
	 * 
	 * @return salt
	 * @throws NoSuchAlgorithmException
	 */
	public static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return Arrays.toString(salt);
	}

	/**
	 * Get password hash
	 * 
	 * @param password Plain text password
	 * @param secret   Secret key
	 * @param salt     Random salt
	 * @return Password hash.
	 */
	public static String getPasswordHash(String password, String salt) {

		try {

			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			return Base64.getEncoder().encodeToString(tmp.getEncoded());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * This method is used to validate given password is correct or not.
	 * 
	 * @param newPassword     new password from user.
	 * @param oldHashPassword password stored in db.
	 * @param salt            String
	 * @return true or false.
	 */
	public static boolean isPasswordCorrect(String newPassword, String oldHashPassword, String salt) {
		return oldHashPassword.equals(getPasswordHash(newPassword, salt));
	}

	/**
	 * This method use to generate a random AlphaNumeric String using Math.random()
	 * method
	 * 
	 * @param number input number(like 500, 123, 780)
	 * @return random String
	 */
	public static String getRandomString(int number) {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(number);

		for (int i = 0; i < number; i++) {

			int index = (int) (AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	/**
	 * This method is used to get user id for Jwt Token.
	 * 
	 * @return {@link User}
	 */
	public static long getJwtUserId() {

		UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getId();

	}

	public static String saveFile(MultipartFile file, String title) throws IOException {

		String path = Constants.UPLOAD_PATH + title + new Date().getTime() + "."
				+ FilenameUtils.getExtension(file.getOriginalFilename());
		;

		String storedFilePath = Constants.BASE_URL;

		File convFile = new File(path);

		convFile.createNewFile();

		FileOutputStream fos = new FileOutputStream(convFile);

		fos.write(file.getBytes());

		fos.close();

		storedFilePath = storedFilePath + convFile.getName();

		return storedFilePath;
	}
	
	
	public static Long convertDateStringToMilliseconds(String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			return sdf.parse(dateString).getTime();
		} catch (ParseException e) {
			throw new RuntimeException("Invalid date format. Please use dd-MM-yyyy.", e);
		}
	}
}
