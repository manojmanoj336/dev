/*package com.app.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.shayari.common.utils.ExcelReader;
import com.app.shayari.common.utils.MetaDataContent;
import com.app.shayari.model.Shayari;
import com.app.shayari.model.ShayariLanguages;
import com.app.shayari.resp.GenericResponse;
import com.app.shayari.resp.RespData;
import com.app.shayari.service.ShayariService;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {

	@Autowired
	ShayariService service;
	
	@Autowired
	GenericResponse gr;
	
	@Autowired
	RespData data;
	
		
	
	@RequestMapping(value = "/lena/{code}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("code") String code) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/"+code+".jpg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
	@RequestMapping(value ="/info", method= RequestMethod.GET)
	List<Shayari> getData()
	{
		System.out.println("POST info CALLED: " + new Timestamp(System.currentTimeMillis()));
		return service.getShayaries();	
	}
	
	@RequestMapping(value ="/info", method= RequestMethod.POST)
	GenericResponse getData1()
	{
		System.out.println("POST info CALLED: " + new Timestamp(System.currentTimeMillis()));
		data.setShayaries(service.getShayaries());
		gr.setRespDap(data);
		gr.setStatusCode(0);
		gr.setStatusDesc("success");
		
		return gr;	
	}
	
	
	
	@RequestMapping(value ="/saveShayari", method= RequestMethod.POST)
	String saveShayaries(@RequestParam("data") String data)
	{
		
	Shayari shayari = new Shayari();	
	ShayariLanguages lang = new ShayariLanguages();
		if(!(data ==null))
		{	
			data = data.replaceAll("\\s", "");
			System.out.println("data is: " + data);
			
			if(data.contains("^"))
			{
				
				String [] str = data.split("^");
				
				
				for(String str1: str)
				{
				lang.setData(str1);
				lang.setLangCode(1);
				}
				
				
				
			}else{
				
				
			}
			
			
			
		}else{
			
			
			
			
			
		}
		
		
		
		
		
		
		
		return "ok";
	}
	
	
	
	
	
	
	@RequestMapping(value ="/saveShayari", method= RequestMethod.GET)
	String saveShayari()
	{
		Shayari s = new Shayari();
		service.save(s);
		return "success";	
	}
	
	
	
	@RequestMapping(value ="/uploadcheck", method= RequestMethod.GET)
	List<MetaDataContent> getDataa()
	{
		
	//	MetaDataContent d = new MetaDataContent();
		List<MetaDataContent> list = new ArrayList<MetaDataContent>();
	//	ExcelReader reader = new ExcelReader();
		list = ExcelReader.getMetaData(" ");
		
		
		
		for(MetaDataContent metadata : list) {
			Shayari shayari = new Shayari();
			Set<ShayariLanguages> languages = new HashSet<ShayariLanguages>();
			shayari.setCategory("love shayari");
			shayari.setMediatype("text");
			shayari.setShayariCode(metadata.getUniqueId());
			shayari.setTimestamp(new Timestamp(System.currentTimeMillis()));
			
			if(null != metadata.getEnglish_content() || metadata.getEnglish_content() !="") {
				ShayariLanguages lang1 = new ShayariLanguages();
				lang1.setData(metadata.getEnglish_content());
				lang1.setLangCode(1);
				languages.add(lang1);
			}
			if(null != metadata.getHindi_content() || metadata.getHindi_content() !="") {
				ShayariLanguages lang2 = new ShayariLanguages();
				lang2.setData(metadata.getHindi_content());
				lang2.setLangCode(2);
				languages.add(lang2);
			}
			
			shayari.setLanguages(languages);
			service.save(shayari);
			
			
		}
				
		return list;	
	}
	
	
	
	
	
	
	
	
}
*/