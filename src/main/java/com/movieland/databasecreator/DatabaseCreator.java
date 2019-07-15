package com.movieland.databasecreator;

import com.movieland.databasecreator.service.LineParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class DatabaseCreator {

	public static void main(String[] args)
		throws IOException, SQLException {
		File file = new File("");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),
			StandardCharsets.UTF_8))) {
			LineParser.parseLine(file, reader);
		}
	}
}
