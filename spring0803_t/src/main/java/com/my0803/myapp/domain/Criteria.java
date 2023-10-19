package com.my0803.myapp.domain;

//�럹�씠吏뺤쓣 �븯湲� �쐞�븳 湲곗��씠 �릺�뒗 �뜲�씠�꽣 �겢�옒�뒪
public class Criteria {
	
	private int page;  //�럹�씠吏�踰덊샇瑜� �떞�뒗 蹂��닔
	private int perPageNum;// /由ъ뒪�듃 寃뚯떆臾� �닔
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 15;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

}
