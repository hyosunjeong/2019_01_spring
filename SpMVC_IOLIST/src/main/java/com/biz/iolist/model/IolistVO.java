package com.biz.iolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IolistVO {
	
	private long io_id;
	private String io_date;	
	private String io_pcode;	
    private String io_dcode;	
    private String io_inout;		
    private String io_tax;
    private int io_quan;		
    private int io_price;	
    private int io_total;		
    private int io_tax_total;	

}
