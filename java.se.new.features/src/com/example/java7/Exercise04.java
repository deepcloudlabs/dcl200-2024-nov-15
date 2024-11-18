package com.example.java7;

import java.io.Closeable;
import java.io.IOException;

public class Exercise04 {

	public static void main(String[] args)  {
		PreciousResource res1 = new PreciousResource();
		PreciousResource res2 = new PreciousResource();
		PreciousResource res3 = new PreciousResource();
		try {
			
		}catch (Exception e) {
			
		} finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.out.println("Error has occured while closing the resource.");
			}finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.out.println("Error has occured while closing the resource.");
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.out.println("Error has occured while closing the resource.");
					}
				}
			}
		}

	}

}

class PreciousResource implements Closeable{

	@Override
	public void close() throws IOException {
		System.out.println("Closing the resource");
		throw new IOException("Oooppps!");
	}
	
}