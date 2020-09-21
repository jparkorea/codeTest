package com.example.codeTest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.codeTest.helper.RestApiHelper;
import com.example.codeTest.web.dto.InfoDto;
import com.example.codeTest.web.entity.Document;
import com.example.codeTest.web.entity.Keyword;
import com.example.codeTest.web.repository.DocumentRepository;
import com.example.codeTest.web.service.BoardService;
import com.example.codeTest.web.service.KeywordService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@Autowired
	private KeywordService keywordService;

	@Autowired
	private DocumentRepository documentRepository;

	@GetMapping("/search")
	public ModelAndView search(ModelAndView m) {

		List<Keyword> keywords = keywordService.getList();
		m.addObject("keywords", keywords);

		m.setViewName("board/search");
		return m;
	}

	@GetMapping("/view")
	public String viewGet(@RequestParam(value = "query", required = false) String query
			, @RequestParam(value = "initQuery", required = false) String initQuery
			, Model m
			, @PageableDefault(size = 10) Pageable pageable) throws Exception {
		
		Page<Document> documents = null;

		// 검색 버튼을 통해 최초 query만 가졌을 때
		if (initQuery != null && query == null) {

			// 최초 query에 값이 없으면 검색페이지로 재이동 
			if(initQuery.trim().equals("")) {
				return "redirect:search";
			}
			
			query = initQuery;
			InfoDto infoDto = new InfoDto();
			infoDto = boardService.locationByKeyword(query);
			for (int i = 0; i < infoDto.documents.size(); i++) {
				infoDto.documents.get(i).query = query;
				infoDto.documents.get(i).map_url = RestApiHelper.getMapUrl() + infoDto.documents.get(i).id;

				// 검색 데이터 DB 저장
				Document document = new Document(infoDto.documents.get(i));
				documentRepository.save(document);
			}

			// 키워드 Count 증가
			List<Keyword> keywords = keywordService.addCountAndGetList(query);
			m.addAttribute("keywords", keywords);
			m.addAttribute("query", initQuery);

		}else if(initQuery == null && query != null){
			//query가 null이 아니면 keyword와 query를 적재
			
			List<Keyword> keywords = keywordService.getList();
			m.addAttribute("keywords", keywords);
			m.addAttribute("query", query);
			
		}else { 
			//initQuery와 query가 null이면 keyword만 적재

			List<Keyword> keywords = keywordService.getList();
			m.addAttribute("keywords", keywords);
			
		}
		
		documents = documentRepository.findByQuery(query, pageable);

		int startPage = Math.max(1, documents.getPageable().getPageNumber() - 4);
		int endPage = Math.min(documents.getTotalPages(), documents.getPageable().getPageNumber() + 4);

		m.addAttribute("startPage", startPage);
		m.addAttribute("endPage", endPage);
		m.addAttribute("documents", documents);
		
		return "board/view";
	}

}
