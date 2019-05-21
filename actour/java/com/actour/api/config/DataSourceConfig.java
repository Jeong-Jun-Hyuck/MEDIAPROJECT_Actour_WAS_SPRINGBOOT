package com.actour.api.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DataSourceConfig {
	@Bean
	public SimpleDriverDataSource dataSource() {
		File file = new File("E:\\DevOfServerOfMediaProject\\confile\\scr.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String in[] = new String[3];
		for(int i=0;i<3;i++){
			try {
				in[i]=bufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/"+in[0]+"?characterEncoding=UTF-8&serverTimezone=UTC&allowMultiQueries=true");
		dataSource.setUsername(in[1]);
		dataSource.setPassword(in[2]);
		return dataSource;
	}
}
