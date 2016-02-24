package com.ada.common.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Internal static utilities for handling data.
 * 
 */
public class DataUtil {
	private static final Pattern charsetPattern = Pattern
			.compile("(?i)\\bcharset=\\s*\"?([^\\s;\"]*)");
	public static final String defaultCharset = "UTF-8"; // used if not found in
															// header
	// or meta charset
	private static final int bufferSize = 0x20000; // ~130K.

	public DataUtil() {
	}

	/**
	 * Loads a file to a Document.
	 * 
	 * @param in
	 *            file to load
	 * @param charsetName
	 *            character set of input
	 * @param baseUri
	 *            base URI of document, to resolve relative links against
	 * @return Document
	 * @throws IOException
	 *             on IO error
	 */

	public static ByteBuffer readToByteBuffer(InputStream inStream)
			throws IOException {
		byte[] buffer = new byte[bufferSize];
		ByteArrayOutputStream outStream = new ByteArrayOutputStream(bufferSize);
		int read;
		while (true) {
			read = inStream.read(buffer);
			if (read == -1)
				break;
			outStream.write(buffer, 0, read);
		}
		ByteBuffer byteData = ByteBuffer.wrap(outStream.toByteArray());
		return byteData;
	}

	/**
	 * Parse out a charset from a content type header.
	 * 
	 * @param contentType
	 *            e.g. "text/html; charset=EUC-JP"
	 * @return "EUC-JP", or null if not found. Charset is trimmed and
	 *         uppercased.
	 */
	static String getCharsetFromContentType(String contentType) {
		if (contentType == null)
			return null;

		Matcher m = charsetPattern.matcher(contentType);
		if (m.find()) {
			return m.group(1).trim().toUpperCase();
		}
		return null;
	}

}
