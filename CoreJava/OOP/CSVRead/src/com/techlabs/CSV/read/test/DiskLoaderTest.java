package com.techlabs.CSV.read.test;

import java.io.IOException;
import java.util.List;

import com.techlabs.CSV.read.DiskLoader;


public class DiskLoaderTest {

	public static void main(String[] args) throws IOException {
		DiskLoader disk=new DiskLoader();
		List<String> line=disk.load();
		for(String s:line){
			System.out.println(s);
		}
		System.out.println(line.size());
	}
}
