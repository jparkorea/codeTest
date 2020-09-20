package com.example.codeTest.web.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.example.codeTest.web.dto.InfoDto;

public interface BoardService {

	InfoDto locationByKeyword(String query) throws MalformedURLException, IOException;
}
