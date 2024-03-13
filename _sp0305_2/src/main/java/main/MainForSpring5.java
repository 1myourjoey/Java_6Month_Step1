package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfImport;
import config.AppCtx;
import config.AppCtxNoMemberPrinterBean;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongIdPasswordException;
import spring.MemberPrinter;

public class MainForSpring5 {
	
	private static ApplicationContext ctx = null;
	
	
	public static void main (String [] args) throws IOException {
		
		ctx = new AnnotationConfigApplicationContext(AppCtxNoMemberPrinterBean.class);
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어 입력");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료");
				break;
			}
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if (command.equals("list")) {
				processListCommand();
				continue;
			} else if (command.startsWith("info")) {
				processInfoCommand(command.split(" "));
				continue;
			} else if (command.equals("version")) {
				processVersionCommand();
				continue;
			}
			
			printHelp();
		
	}
	}
	
	
	private static void processNewCommand(String[]arg) {
		if(arg.length !=5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인 일치 않음.\n");
			return;	
		}
		try{
			regSvc.regist(req);
			System.out.println("등록.\n");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일.\n");
		}
	}
	
		private static void processChangeCommand(String[] arg) {
		if(arg.length !=4) {
			printHelp();
			return;
}
		ChangePasswordService changePwdSvc =
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했어.\n");
		} catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일\n");
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 암호 일치 않음\n");
		}
		}
		private static void printHelp() {
			System.out.println();
			System.out.println("잘못된 명령. 아래 명령어 사용법 확인");
			System.out.println("명령어 사용법");
			System.out.println("new 이메일 이름 암호 암호확인");
			System.out.println("change 이메일 현재비번 변경비번");
			System.out.println();
		}
		private static void processListCommand() {
			MemberListPrinter listPrinter =
					ctx.getBean("listPrinter",MemberListPrinter.class);
			listPrinter.printAll();
		}
		private static void processInfoCommand(String[]arg) {
			if (arg.length!=2) {
				printHelp();
				return;
			}
			MemberInfoPrinter infoPrinter =
					ctx.getBean("infoPrinter", MemberInfoPrinter.class);
			infoPrinter.printMemberInfo(arg[1]);
		}
		private static void processVersionCommand() {
			VersionPrinter versionPrinter =
					ctx.getBean("versionPrinter", VersionPrinter.class);
			versionPrinter.print();
		}

}
		
		
		
		
		
		
		