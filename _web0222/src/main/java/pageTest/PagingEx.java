package pageTest;

public class PagingEx {

	public static void main(String[] args) {
		int totalPage=13;
		for (int i=1; i<=20; i++)	{
			pageTest(i, totalPage);
		}

	}
	
	public static void pageTest(int currentPage, int totalPages) {
		int modVal = currentPage % 5; // 나머지 계산
		int startPage = currentPage / 5 * 5 + 1;
		if(modVal==0) startPage -= 5;
		//startPage,endPage: 화면 하단 보여줄 ㅔㅍ이지 이동 링크의 시작 번호와 끝 번호
		int endPage = startPage+4;
		if(endPage>totalPages) endPage = totalPages;
		System.out.println("startPage: "+startPage +",endPage: " + endPage);
	}

}
