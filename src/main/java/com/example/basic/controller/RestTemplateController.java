package com.example.basic.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
	@GetMapping("/getKakao")
	public ResponseEntity<Map> getKakao(String address) {
		RestTemplate rt = new RestTemplate();
		RequestEntity requestEntity = null;
		try {
			requestEntity = RequestEntity
					.get(new URI("https://dapi.kakao.com/v2/local/search/address.json?query="
							+ URLEncoder.encode(address , "utf-8")))
					.header("Authorization", "KakaoAK 5d3626732b2ea95702e1948e50a0624f").build();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return entity;
	}
	
	
	
	@GetMapping("/getNaver")
	public ResponseEntity<Map> getNaver(String text) {
		RestTemplate rt = new RestTemplate();
		RequestEntity<Map<String, String>> requestEntity = null;
		try {
			Map<String, String> body = new HashMap<>();
			body.put("source", "ko");
			body.put("target", "en");
			body.put("text", text);
			requestEntity = RequestEntity
					.post(new URI("https://openapi.naver.com/v1/papago/n2mt"))
					.header("X-Naver-Client-Id", "luTWH2TgUj6WT_cIta1i")
					.header("X-Naver-Client-Secret", "DilYy6o8IQ")
					.body(body);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return entity;
	}
	
	
	@GetMapping("/getKakaoT")
	public ResponseEntity<Map> getKakaoT(String text) {
		RestTemplate rt = new RestTemplate();
		RequestEntity requestEntity = null;
		try {
			requestEntity = RequestEntity
					.get(new URI("https://dapi.kakao.com/v2/translation/translate?"
							+ "src_lang=kr&target_lang=en&query=" + URLEncoder.encode(text , "utf-8")))
					.header("Authorization", "KakaoAK 5d3626732b2ea95702e1948e50a0624f")
					.build();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return entity;
	}
	
	  @GetMapping("/getNaverR")
	  public Map getNaverRoma(String text) throws UnsupportedEncodingException {
	    RestTemplate rt = new RestTemplate();
	    RequestEntity<Void> requestEntity = null;
	    try {
	      Map<String, String> body = new HashMap<>();
	      requestEntity = RequestEntity
	    	  .get(new URI("https://openapi.naver.com/v1/krdict/romanization?query=" +
	                   URLEncoder.encode(text, "utf-8")))
	          .header("X-Naver-Client-Id", "R07YjSsPeO846YoVTd5P")
	          .header("X-Naver-Client-Secret", "4J2kcTlDku")
	          .build();
	    } catch (URISyntaxException e) {
	      e.printStackTrace();
	    }
	    ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
	    return entity.getBody();
	  }

	
	
}