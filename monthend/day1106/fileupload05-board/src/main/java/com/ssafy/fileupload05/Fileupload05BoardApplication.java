package com.ssafy.fileupload05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.fileupload05.repository.mapper")
public class Fileupload05BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fileupload05BoardApplication.class, args);
	}

}
