package com.my0803.myapp.domain;

import org.springframework.stereotype.Component;

@Component
public class PageMaker {
	
	private int displayPageNum =10;
	private int startPage;  
	private int endPage;  
	private int totalCount; 
	
	private boolean prev; 
	private boolean next; 
	
	private SearchCriteria scri;

	public SearchCriteria getScri() {
		return scri;
	}

	public void setScri(SearchCriteria scri) {
		this.scri = scri;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();  //�럹�씠吏�紐⑸줉媛��닔瑜� �굹���궡二쇨린 �쐞�븳 怨꾩궛�떇
	}

	private void calcData() {
		
		//1.湲곕낯�쟻�쑝濡� 1�뿉�꽌 10源뚯� �굹���굹寃� �꽕�젙
		endPage = (int)(Math.ceil(scri.getPage()/(double)displayPageNum)*displayPageNum);
		
		//2.endPage瑜� �꽕�젙�뻽�쑝硫� �떆�옉�럹�씠吏��룄 �꽕�젙
		startPage  = (endPage-displayPageNum)+1;
		
		//3.�떎�젣 �럹�씠吏� 媛믪쓣 戮묎쿋�떎
		int tempEndPage = (int)Math.ceil(totalCount/(double)scri.getPerPageNum());
		
		//4.�꽕�젙endPage�� �떎�젣endPage 鍮꾧탳�븳�떎
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//5.�씠�쟾�떎�쓬踰꾪듉 �쑀臾�
		prev = (startPage ==1 ? false:true);
		next = (endPage*scri.getPerPageNum() >= totalCount ? false:true);
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	
	
	
}
