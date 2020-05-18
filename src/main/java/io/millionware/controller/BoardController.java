package io.millionware.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.millionware.service.BoardService;
import io.millionware.vo.BoardVO;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	
	@Inject
	BoardService service;
	
	//글 작성 화면
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
	}
	
	//글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{
		
		//ArrayList는 저장용량(capacity)을 초과한 객체들이 들어오면 자동으로 저쟝용량을 늘린다.
		List<String> listSample = new ArrayList<String>();
		listSample.add(0, "소시지도시락");
		String str = listSample.get(0);
		
		//키와 값의 타입으로 기본 타입(boolean, char 등)을 사용할 수 없다. (int를 쓰고싶다면 Integer로)
		Map<String, String> mapSample = new HashMap<String, String>();
		//객체 추가
		mapSample.put("Action speaks louder","than words");
		mapSample.put("Better safe","than sorry");
		
		//키로 객체 찾기
		String str2 = mapSample.get("Better safe"); //than sorry
		
		//저장된 전체 객체 찾기 (1) 모든 키를 얻은 다음 반복자를 통해 키를 하나씩 얻으며 get()로 값얻기
		Set<String> keySet = mapSample.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			String value = mapSample.get(key);
		}
		
		//저장된 전체 객체 찾기 (2) 모든 Map.Entry를 Set 컬렉션으로 얻은 다음,
		//반복자를 통해 Map.Entry를 하나씩 얻고 getKey()와 getValue()로 키와 값 얻기
		Set<Map.Entry<String, String>> entrySet = mapSample.entrySet();
		Iterator<Entry<String, String>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()){
			Map.Entry<String, String> entry = entryIterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
		}
		
		
		
		
		
		
		service.write(boardVO);
		return "redirect:/board/list123";
	
	}
	
	//글 목록 조회
	@RequestMapping(value="/list123", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		List<BoardVO> list = service.list();
		
		model.addAttribute("list",list);	
		return "board/list";
		 
	}
	
	//글 조회
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception{
		model.addAttribute("read", service.read(boardVO.getBno()));
		return "board/readView";
	}
	
	//글 수정 화면
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model)throws Exception{
		model.addAttribute("update", service.read(boardVO.getBno()));
		return "board/updateView";
	}
	
	//글 수정
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		service.update(boardVO);
		return "redirect:/board/list123";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		service.delete(boardVO.getBno());
		return "redirect:/board/list";
	}
}
