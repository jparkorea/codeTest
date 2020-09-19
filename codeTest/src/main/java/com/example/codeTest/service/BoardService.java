package com.example.codeTest.service;

import java.io.IOException;
import java.net.MalformedURLException;

import com.example.codeTest.dto.InfoDto;

public interface BoardService {

	InfoDto locationByKeyword(InfoDto infoDto) throws MalformedURLException, IOException;
}
