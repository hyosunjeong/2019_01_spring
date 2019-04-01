package com.biz.email.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.mapper.EmsDao;
import com.biz.email.model.EmsVO;

@Service
public class SaveService {

	// 서버에 저장할 주소를 얻어오기 위해서 사용
	@Autowired
	ServletContext context;
	
	@Autowired
	SendMailService sMail;
	
	@Autowired
	EmsDao eDao;
	
	public void save(EmsVO emsVO, MultipartHttpServletRequest files) {

		// files는 입력폼의 file tag의 name 항목과 같게한다.
		List<MultipartFile> fileList = files.getFiles("files");
		
		// 선택한 파일 모두 저장
//		for(MultipartFile f : fileList) {
//			fileUp(f);
//		}
		
		//2개만 저장
		try {
			String fileName1 = fileUp(fileList.get(0)); 
			emsVO.setS_file1(fileName1);
			
			String fileName2 = fileUp(fileList.get(1));
			emsVO.setS_file2(fileName2);
		} catch(Exception e) {
			
		}
		
		
		long id = emsVO.getId();
		if(id>0) {
			eDao.update(emsVO); // 편집상태
		} else {
			eDao.insert(emsVO);
			sMail.sendMail(emsVO);
		}
	}
	
	public String fileUp(MultipartFile file) {
		
		String realFile = file.getOriginalFilename();
		String realPath = context.getRealPath("/files/"); // 실제 서버에 저장할 폴더 위치
		
		File dir = new File(realPath);
		
		if(dir.exists() != true) { // !dir.exits() 파일이 없으면
			dir.mkdir(); // 폴더를 생성해라
		} 
		
		if(file.isEmpty()) { // 업로드된 파일이 문제가 있으면
			return null;
		}
		String saveFile = UUID.randomUUID().toString();
		saveFile += realFile; // 새로운 파일 이름을 생성
		
		File upFile = new File(realPath, saveFile);
		
		try {
			file.transferTo(upFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saveFile; // 실제 저장된 파일 이름을 return
	}

}
