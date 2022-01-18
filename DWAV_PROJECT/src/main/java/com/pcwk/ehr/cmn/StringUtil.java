package com.pcwk.ehr.cmn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class StringUtil {
	/**
	 * 현재 날짜기준  dateFormat을 return
	 * default "yyyyMMdd"
	 * @param dateFormat
	 * @return
	 */
	public static String currentDate(String dateFormat) {
		Date  date =new Date();
		if(null==dateFormat || dateFormat.equals("")) {
			dateFormat = "yyyyMMdd";
		}
		SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
		
		return sdf.format(date);
	}
	
	/**
	 * 32bit UUID 생성
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	
    /**
     * 원본string이 null이면 defaultStr로 치환
     * @param strTarget
     * @param defaultStr
     * @return
     */
	public static String nvl(String strTarget,String defaultStr) {
		if(null == strTarget || "".equals(strTarget)) {
			return defaultStr;
		}
		
		return strTarget;
		
	}	
	/**
	 * 
	 * @param totalNum : 총건수
	 * @param curPage  : 현재 페이지
	 * @param rowPage  : 한 페이지에 보여질 행수
	 * @param bottomPage : 바닥에 보여줄 페이지
	 * @return String(html)
	 */
	/**
	 * 원본string이 null이면 ""으로 치환
	 * @param strTarget
	 * @return 
	 */
	public static String nvl(String strTarget) {
		return nvl(strTarget,"");
	}
	
	/**
	 * 	Paging
	 * @param totalNum : 총건수
	 * @param curPage  : 현재 페이지
	 * @param rowPage  : 한 페이지에 보여질 행수
	 * @param bottomPage : 바닥에 보여줄 페이지
	 * @param url : 호출URL
	 * @param funName : 호출 자바스크립트 함수 
	 * @return String(html)
	 */
	public static String renderPaging(int totalNum, int curPage, int rowPage, int bottomPage, String callURL, String funName) {
		StringBuilder html=new StringBuilder(2000);
		
		int maxNum     = totalNum;  //총건수(21)
		int currPageNo = curPage;   //현재 페이지(1)
		int rowPerPage = rowPage;   //한 페이지에 보여질 행수(10건)
		int bottomCount= bottomPage;//바닥에 보여줄 페이지(10)
		String url     = callURL;   //호출URL(JSer02/board/board.do?boardId=&work_div=retrieve&page_num=&page_size=10&search_div=&search_word=)
		String scriptName = funName;//호출 자바스크립트 함수 (doSearchPage()
		
		//21
		int maxPageNo   = ((maxNum -1)/rowPerPage)+1;//3
		int startPageNo = ((currPageNo-1)/bottomCount)*bottomCount +1;//1
		int endPageNo   = ((currPageNo-1)/bottomCount+1)*bottomCount;//10
		
		int nowBlockNo  = ((currPageNo-1)/bottomCount)+1;//1
		int maxBlockNo  = ((maxNum -1)/bottomCount)+1;   //3
		
		//<< < 1 2 3 4 5 6 7 8 9 10 > >>
		//<< 시작페이지
		//< bottomCount -10;
		// 1 2 3 4 
		//> bottomCount +10;
		//>> 끝페이지
		
		
		
		//for 반복변수
		int inx = 0;
		if(currPageNo > maxPageNo) {
			return "";
		}
		
		html.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >  \n");
		html.append("<tr> \n");
		html.append("<td align=\"center\"> \n");
		html.append("<ul> \n");
		
		//<<
		if(nowBlockNo>1 && nowBlockNo <= maxBlockNo) {
			html.append("<li> <a href=\"javascript:" + scriptName + "( '" + url+ "', 1 );\">  \n");
			html.append("&laquo;");
			html.append("</a></li> \n");
		}
		
		//<
		if(startPageNo>bottomCount) {
			html.append("<li > <a href=\"javascript:" + scriptName + "( '" + url + "'," + (startPageNo - 1)+ ");\"> \n");
			html.append("&lt;");
			html.append("</a></li> \n");			
		}
		
		// 1 2 3 4 5 6 7 8 9 10
		for(inx=startPageNo;inx<=maxPageNo && inx <=endPageNo;inx++) {
		    //a 태그 제거
			if(inx == currPageNo) {
				html.append("<li> ");
				html.append(inx);
				html.append("</li> ");
			}else {
				html.append("<li > <a href=\"javascript:" + scriptName + "( '" + url + "'," + inx+ ");\"> \n");
				html.append(inx);
				html.append("</a></li> \n");				
			}
		
		
		}
		
		//>
		if(maxPageNo >= inx) {
			html.append("<li > <a href=\"javascript:" + scriptName + "( '" + url + "'," + ((nowBlockNo * bottomCount)+1)+ ");\"> \n");
			html.append("&gt;");
			html.append("</a></li> \n");				
		}
		
		//>>
		if(maxPageNo >= inx) {
			html.append("<li > <a href=\"javascript:" + scriptName + "( '" + url + "'," + maxPageNo+ ");\"> \n");
			html.append("&raquo;");
			html.append("</a></li> \n");				
		}
		
		html.append("</ul> \n");
		html.append("</td> \n");
		html.append("</tr> \n");
		html.append("</table> \n");
		
		return html.toString();
	}
	
	
	
}

