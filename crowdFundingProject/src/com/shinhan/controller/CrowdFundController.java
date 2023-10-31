package com.shinhan.controller;

import java.util.List;
import java.util.Scanner;

import com.shinhan.dto.CrowdFundBusinessman;
import com.shinhan.dto.CrowdFundFunding;
import com.shinhan.dto.CrowdFundInvestor;
import com.shinhan.dto.CrowdFundItem;
import com.shinhan.model.CrowdFundService;
import com.shinhan.view.CrowdFundView;

public class CrowdFundController {
	
	static Scanner sc = new Scanner(System.in);
	static CrowdFundService service = new CrowdFundService();
	static boolean isRun = true;
	static boolean isBLogin = true;
	static boolean isILogin = true;
	static boolean isIRun = true;
	
	public static void main(String[] args) {
		
		while(isRun) {
			homeMenu();
			int position = sc.nextInt();
			switch(position) {
			case 1:{
				while(isBLogin) {
					businessmanLoginMenu();
					int log = sc.nextInt();
					switch(log) {
					case 1:{
						System.out.println("-----------회원가입-----------");
						System.out.print("아이디 비밀번호 이름>>");
						CrowdFundBusinessman businessman = new CrowdFundBusinessman(sc.next(),sc.next(),sc.next());
						int count = service.bJoinMembership(businessman);
						CrowdFundView.print(count>0?"회원가입 성공":"회원가입 실패");
						break;
					}
					case 2:{
						System.out.println("-----------로그인-----------");
						System.out.print("아이디 비밀번호>>");
						String businessmanId = sc.next();
						boolean isLogin = service.bLogin(businessmanId,sc.next());
						if(isLogin) {
							businessmanLogic(businessmanId);						
						}else {
							System.out.println("[알림]아이디 혹은 비밀번호가 일치하지 않습니다.");
						}
						break;
					}
					case 3:{
						isBLogin = false;
						break;
					}
					default:{
						System.out.println("다시 선택하세요.");
						break;
					}
					}
				}
				
				break;
			}
			case 2:{
				while(isILogin) {
					investorLoginMenu();
					int log = sc.nextInt();
					switch(log) {
					case 1:{
						System.out.println("-----------회원가입-----------");
						System.out.print("아이디 비밀번호 이름>>");
						CrowdFundInvestor investor = new CrowdFundInvestor(sc.next(),sc.next(),sc.next());
						int count = service.iJoinMembership(investor);
						CrowdFundView.print(count>0?"회원가입 성공":"회원가입 실패");
						break;
					}
					case 2:{
						System.out.println("-----------로그인-----------");
						System.out.print("아이디 비밀번호>>");
						String investorId = sc.next();
						boolean isLogin = service.iLogin(investorId,sc.next());
						if(isLogin) {
							investorLogic(investorId);						
						}else {
							System.out.println("[알림]아이디 혹은 비밀번호가 일치하지 않습니다.");
						}
						break;
					}
					case 3:{
						isILogin = false;
						break;
					}
					default:{
						System.out.println("다시 선택하세요.");
						break;
					}
				}
				}
				break;
			}
			case 3:{
				System.out.println("프로그램을 종료합니다.");
				isRun = false;
				break;
			}
			default:{
				System.out.println("다시 선택하세요.");
				break;
			}
			}
		}

	}
	
	
	
	private static void investorLogic(String investorId) {
		while(isIRun) {
			investorMenu();
			int iJob = sc.nextInt();
			switch(iJob) {
			
			case 1:{
				itemSelect();
				break;
			}
			case 2:{
				System.out.println("-------------펀딩하기-------------");
				System.out.print("상품번호 펀딩할금액>>");
				CrowdFundFunding funding = new CrowdFundFunding(investorId,sc.nextInt(),sc.nextInt());
				int count = service.insertFunding(funding);
				CrowdFundView.print(count>0?"펀딩성공":"펀딩실패");
				break;
			}
			case 3:{
				myPage(investorId);
				break;
			}
			case 4:{
				isIRun = false;
				break;
			}
			case 5:{
				System.out.println("프로그램을 종료합니다.");
				isIRun = false;
				isILogin = false;
				isRun = false;
				break;
			}
			default:{
				System.out.println("다시 선택하세요.");
				break;
			}
			}
		}
	}

	private static void itemSelect() {
		boolean psIsRun = true;
		while (psIsRun) {
			itemSelectionMenu();
			int psJob = sc.nextInt();
			switch(psJob) {
			case 1:{
				System.out.println("-------------전체보기-------------");
				List<CrowdFundItem> clist = service.selectAll();
				CrowdFundView.print(clist);
				break;
			}
			case 2:{
				System.out.println("-----------인기순으로 보기-----------");
				List<CrowdFundItem> clist = service.selectByPopularity();
				CrowdFundView.print(clist);
				break;
			}
			case 3:{
				System.out.println("------------검색해서 보기------------");
				System.out.print("상품이름>>");
				String search = sc.next();
				List<CrowdFundItem> clist = service.selectBySearch(search);
				CrowdFundView.print(clist);
				break;
			}
			case 4:{
				psIsRun = false;
				break;
			}
			case 5:{
				System.out.println("프로그램을 종료합니다.");
				psIsRun = false;
				isIRun = false;
				isILogin = false;
				isRun = false;
				break;
			}
			default:{
				System.out.println("다시 선택하세요.");
				break;
			}
			}
		}
		
	}
	
	private static void myPage(String investorId) {
		boolean isPageRun = true;
		while(isPageRun) {
			pageMenu();
			int pJob = sc.nextInt();
			switch(pJob) {
			case 1:{
				System.out.println("---------나의 펀딩금액 조회----------");
				List<CrowdFundFunding> clist = service.checkFunding(investorId);
				CrowdFundView.print2(clist);
				break;
			}
			case 2:{
				System.out.println("---------나의 펀딩상품 조회----------");
				List<CrowdFundItem> clist = service.selectByIid(investorId);
				CrowdFundView.print(clist);
				break;
			}
			case 3:{
				System.out.println("----------잔고 확인-----------");
				CrowdFundInvestor investor = service.checkBalance(investorId);
				CrowdFundView.balancePrint(investor);
				break;
			}
			case 4:{
				System.out.println("----------금액 충전-----------");
				System.out.print("충전금액>>");
				int count = service.chargeAmount(investorId,sc.nextInt());
				CrowdFundView.print(count>0?"충전성공":"충전실패");
				break;
			}
			case 5:{
				isPageRun = false;
				break;
			}
			case 6:{
				System.out.println("프로그램을 종료합니다.");
				isPageRun = false;
				isIRun = false;
				isILogin = false;
				isRun = false;
				break;
			}
			default:{
				System.out.println("다시 선택하세요.");
				break;
			}
			}
		}	
	}


	
	private static void businessmanLogic(String businessmanId) {
		boolean isBRun = true;
		while(isBRun) {
			businessmanMenu();
			int bJob = sc.nextInt();
			switch(bJob) {
			case 1:{
				System.out.println("-----------펀딩상품 등록-----------");
				sc.nextLine();
				System.out.print("상품이름>>");
				String itemName = sc.nextLine();
				System.out.print("상품소개>>");
				String itemInfo = sc.nextLine();
				System.out.print("목표금액>>");
				int targetAmount = sc.nextInt();
				CrowdFundItem item = new CrowdFundItem(businessmanId,itemName,itemInfo,targetAmount);
				int count = service.registerItem(item);
				CrowdFundView.print(count>0?"상품등록 성공":"상품등록 실패");
				break;
			}
			case 2:{
				System.out.println("-----------펀딩상품 삭제-----------");
				System.out.print("상품번호>>");
				int count = service.deleteItem(sc.nextInt());
				CrowdFundView.print(count>0?"상품삭제 성공":"상품삭제 실패");
				break;
			}
			case 3:{
				System.out.println("---------나의 펀딩상품 조회----------");
				List<CrowdFundItem> clist = service.selectByBid(businessmanId);
				CrowdFundView.print(clist);
				break;
			}
			case 4:{
				isBRun = false;
				break;
			}
			case 5:{
				System.out.println("프로그램을 종료합니다.");
				isBRun = false;
				isBLogin = false;
				isRun = false;
				break;
			}
			default:{
				System.out.println("다시 선택하세요.");
				break;
			}
			}
		}
	}
	
	private static void itemSelectionMenu() {
		System.out.println("====================");
		System.out.println("     펀딩상품 조회      ");
		System.out.println("====================");
		System.out.println("1.전체보기");
		System.out.println("2.인기순으로 보기");
		System.out.println("3.검색해서 보기");
		System.out.println("4.이전페이지");
		System.out.println("5.프로그램 종료");
		System.out.print("번호 선택>>");
		
	}
	
	private static void pageMenu() {
		System.out.println("====================");
		System.out.println("       마이페이지        ");
		System.out.println("====================");
		System.out.println("1.나의 펀딩금액 조회");
		System.out.println("2.나의 펀딩상품 조회");
		System.out.println("3.잔고 확인");
		System.out.println("4.금액 충전");
		System.out.println("5.이전페이지");
		System.out.println("6.프로그램 종료");
		System.out.print("번호 선택>>");
	}

	private static void investorLoginMenu() {
		System.out.println("====================");
		System.out.println("     회원가입/로그인     ");
		System.out.println("====================");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.홈");
		System.out.print("번호선택>>");
	}

	private static void businessmanLoginMenu() {
		System.out.println("====================");
		System.out.println("     회원가입/로그인     ");
		System.out.println("====================");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.홈");
		System.out.print("번호선택>>");
	}
	
	private static void investorMenu() {
		System.out.println("====================");
		System.out.println("        투자자        ");
		System.out.println("====================");
		System.out.println("1.펀딩상품 조회");
		System.out.println("2.펀딩하기");
		System.out.println("3.마이페이지");
		System.out.println("4.이전페이지");
		System.out.println("5.프로그램 종료");
		System.out.print("번호 선택>>");
	}

	private static void businessmanMenu() {
		System.out.println("====================");
		System.out.println("        사업가        ");
		System.out.println("====================");
		System.out.println("1.펀딩상품 등록");
		System.out.println("2.펀딩상품 삭제");		
		System.out.println("3.나의 펀딩상품 조회");		
		System.out.println("4.이전페이지");
		System.out.println("5.프로그램 종료");
		System.out.print("번호 선택>>");
	}

	private static void homeMenu() {
		System.out.println("====================");
		System.out.println("        Home        ");
		System.out.println("====================");
		System.out.println("1.사업가");
		System.out.println("2.투자자");
		System.out.println("3.프로그램 종료");
		System.out.print("번호 선택>>");
	}

}
