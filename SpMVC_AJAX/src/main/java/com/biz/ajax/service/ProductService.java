package com.biz.ajax.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.biz.ajax.model.ProductVO;



@Service
public class ProductService {
	String fileName="product.txt";
	
	public List<ProductVO> getProduct(){
		
		ClassPathResource rs = new ClassPathResource(fileName);
		
		InputStreamReader is;
		BufferedReader buffer;
		
		try {
			is = new InputStreamReader(rs.getInputStream());
			buffer = new BufferedReader(is);
			String reader ="";
			List<ProductVO> pList = new ArrayList<ProductVO>();
			
			while(true) {
				reader = buffer.readLine();
				if(reader ==null) break;
				
				String[] product = reader.split(":");
				
				ProductVO vo = new ProductVO();
				vo.setP_ccode(product[0]);
				vo.setP_cname(product[1]);
				vo.setP_vat(product[2]);
				vo.setP_iprice(Integer.valueOf(product[3]));
				vo.setP_oprice(Integer.valueOf(product[4]));
				
				pList.add(vo);
			}
			return pList;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
	
	}
	
	
}
