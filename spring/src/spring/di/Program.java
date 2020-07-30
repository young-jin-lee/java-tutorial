package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* DEPENDENCY INJECTION2 */
//		Exam exam = new NewlecExam();
//		ExamConsole console = new GridExamConsole();
//		console.setExam(exam);
//		console.print();
		
		/* 스프링에게 지시하는 방법으로 코드를 변경 */
		
		// 1. Exam exam = new NewlecExam();
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				//new ClassPathXmlApplicationContext("spring/di/setting.xml"); // 지시서를 읽어오는 방법
		
		// 2. ExamConsole console = new GridExamConsole(exam);
		//    console.setExam(exam);
		ExamConsole console = (ExamConsole) context.getBean("console"); // 1. console이라는 id로 찾기
		//ExamConsole console = context.getBean(ExamConsole.class); // 2. ExamConsole이라는 객체 타입으로 찾기; 이걸 쓰면  GridExamConsole에서 어노테이션에 "console"이라고 입력하지 않아도 됨.
		console.print();
		
		// 2. exam.setExam(exam);
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());	
	}
}
