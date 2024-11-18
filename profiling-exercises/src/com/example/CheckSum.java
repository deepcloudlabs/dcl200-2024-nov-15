package com.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class CheckSum {

	public static long checksumInputStream(String filename) throws IOException {
		CRC32 crc = new CRC32();
		try (InputStream in = new FileInputStream(filename)) {
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
		}
		return crc.getValue();
	}

	public static long checksumBufferedInputStream(String filename) throws IOException {
		CRC32 crc = new CRC32();
		try (InputStream in = new BufferedInputStream(new FileInputStream(filename))) {
			int c;
			while ((c = in.read()) != -1) {
				crc.update(c);
			}
		}
		return crc.getValue();
	}

	public static long checksumRandomAccessFile(String filename) throws IOException {
		CRC32 crc = new CRC32();
		try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
			long length = file.length();
			for (long p = 0; p < length; p++) {
				file.seek(p);
				int c = file.readByte();
				crc.update(c);
			}
		}
		return crc.getValue();
	}

	public static long checksumMappedFile(String filename) throws IOException {
		CRC32 crc = new CRC32();
		try (FileInputStream in = new FileInputStream(filename); FileChannel channel = in.getChannel();) {
			int length = (int) channel.size();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
			buffer.order(ByteOrder.LITTLE_ENDIAN);
			System.err.println(buffer.order());
			for (int p = 0; p < length; p++) {
				int c = buffer.get(p);
				crc.update(c);
			}
		}
		return crc.getValue();
	}

	public static void main(String[] args) throws IOException {
		String fileName = "src/sentiment140.csv";
		System.out.println("Input Stream:");
		long start = System.currentTimeMillis();
		long crcValue = checksumInputStream(fileName);
		long end = System.currentTimeMillis();
		System.out.println("CRC: " + Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");

		System.out.println("Buffered Input Stream:");
		start = System.currentTimeMillis();
		crcValue = checksumBufferedInputStream(fileName);
		end = System.currentTimeMillis();
		System.out.println("CRC: " + Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");

		System.out.println("Random Access File:");
		start = System.currentTimeMillis();
		crcValue = checksumRandomAccessFile(fileName);
		end = System.currentTimeMillis();
		System.out.println("CRC: " + Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");

		System.out.println("Mapped File:");
		start = System.currentTimeMillis();
		crcValue = checksumMappedFile(fileName);
		end = System.currentTimeMillis();
		System.out.println("CRC: " + Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");
	}
}
