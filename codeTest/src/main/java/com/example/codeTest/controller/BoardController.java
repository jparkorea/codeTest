package com.example.codeTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.codeTest.domain.entity.KeywordEntity;
import com.example.codeTest.domain.repository.KeywordRepository;
import com.example.codeTest.dto.InfoDto;
import com.example.codeTest.helper.RestApiHelper;
import com.example.codeTest.service.BoardService;
import com.example.codeTest.service.KeywordService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private KeywordRepository keywordRepository;

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private KeywordService keywordService;

	@GetMapping("/search")
	public ModelAndView search(ModelAndView m) {
		
		List<KeywordEntity> keywords = keywordService.getList();
		m.addObject("keywords", keywords);
		
		m.setViewName("board/search");
		return m;
	}

	@PostMapping("/view")
	public ModelAndView view(@RequestParam("query") String query, ModelAndView m) throws Exception {

		InfoDto infoDto = new InfoDto();
		infoDto.query = query;
		infoDto = boardService.locationByKeyword(infoDto);
		for(int i=0; i<infoDto.documents.size(); i++) {
			infoDto.documents.get(i).map_url = RestApiHelper.getMapUrl() + infoDto.documents.get(i).id;
		}
//		infoDto.mapUrl = RestApiHelper.getMapUrl()+infoDto.documents.;
		/*
		 * 들어온 query에 대해서 OpenAPI 처리를 하고, query와 카운트 있는지 로직 하고, 검색결과 페이지네이션 형태 검색어와 검색버튼
		 * 유지할건지 선택
		 */
		List<KeywordEntity> keywords = keywordService.addCountAndGetList(query);
		m.addObject("keywords", keywords);
		
		m.addObject("infoList", infoDto.documents);
		m.addObject("query", query);
		m.setViewName("/board/view");
		return m;
	}

	@GetMapping("/view?{id}")
	public void view(@PathVariable("id") Long id) throws Exception {
		//TODO id를 ?query로 받아서 상세보기 화면(새로 만들어)으로 가야 함. ID값을 받아서 넘겨줘야 함.
		System.out.println(id);
	}
	
}
