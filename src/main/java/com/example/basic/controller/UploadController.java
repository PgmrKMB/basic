package com.example.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.basic.model.FileAtch;
import com.example.basic.repository.FileAtchRepository;

@Controller
public class UploadController {
	@Autowired
	FileAtchRepository fa;
	
	
	
	@GetMapping("/upload1")
	public String upload1() {
		return "upload1";
	}

	@PostMapping("/upload1")
	@ResponseBody
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		MultipartFile mFile = mRequest.getFile("file");
		String oName = mFile.getOriginalFilename();
		long size = mFile.getSize();

		result += oName + "\n";

		File f = new File("c:/hrdkmb/" + oName);
		String sName = "";

		if (f.isFile()) {
			String fname = oName.substring(0, oName.lastIndexOf("."));
			String fext = oName.substring(oName.lastIndexOf("."));
			long time = System.currentTimeMillis();
			sName = fname + "_" + time / 1000000 + fext;
		} else {
			sName = oName;
		}

		try {
			mFile.transferTo(new File("c:/hrdkmb/" + sName));

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result + size;
	}

	@GetMapping("/upload2")
	public String upload2() {
		return "upload2";
	}

	@PostMapping("/upload2")
	@ResponseBody
	public String upload2Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		Iterator<String> iter = mRequest.getFileNames();
		while (iter.hasNext()) {
			String inputName = iter.next();
			List<MultipartFile> mFiles = mRequest.getFiles(inputName);
			for (MultipartFile mFile : mFiles) {
				String oName = mFile.getOriginalFilename();
				
				result += oName +"\n";
				
				if(oName == null || oName.equals("")) {
					break;
				}
				
				try {
					FileAtch fatc = new FileAtch();
					fatc.setOriginalName(oName);
					fa.save(fatc);
					
					mFile.transferTo(new File("c:/hrdkmb/" + oName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}