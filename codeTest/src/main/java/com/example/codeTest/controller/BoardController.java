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
	public String view(@RequestParam(value = "query", required = false) String query, 
			Model m, 
			@PageableDefault(size = 10) Pageable pageable) throws Exception {

		if(query == null || query.trim().equals("")) {
			List<Keyword> keywords = keywordService.getList();
			m.addAttribute("keywords", keywords);
			
		}else {
			InfoDto infoDto = new InfoDto();
			infoDto = boardService.locationByKeyword(query);
			for(int i=0; i<infoDto.documents.size(); i++) {
				infoDto.documents.get(i).query = query;
				infoDto.documents.get(i).map_url = RestApiHelper.getMapUrl() + infoDto.documents.get(i).id;

				Document document = new Document(infoDto.documents.get(i));
				documentRepository.save(document);
			}
			
			//페이징 처리
			Page<Document> documents = documentRepository.findByQuery(query, pageable);
			
			int startPage = Math.max(1, documents.getPageable().getPageNumber() - 4);
			int endPage = Math.min(documents.getTotalPages(), documents.getPageable().getPageNumber() + 4);

			m.addAttribute("startPage", startPage);
			m.addAttribute("endPage", endPage);
			m.addAttribute("documents", documents);
			
			List<Keyword> keywords = keywordService.addCountAndGetList(query);
			m.addAttribute("keywords", keywords);
			
			m.addAttribute("query", query);
		}
		
		return "/board/view";
	}

}
