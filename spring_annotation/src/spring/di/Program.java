package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		
		/* DEPENDENCY INJECTION1 */
//		Exam exam = new NewlecExam();
//		ExamConsole console = new InlineExamConsole(exam);
//		ExamConsole console = new GridExamConsole(exam);
//		console.print();
		
		/* DEPENDENCY INJECTION2 */
//		Exam exam = new NewlecExam();
//		ExamConsole console = new GridExamConsole();
//		console.setExam(exam);
//		console.print();
		
		/* 스프링에게 지시하는 방법으로 코드를 변경 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml"); // 지시서를 읽어오는 방법
		
		//ExamConsole console = (ExamConsole) context.getBean("console");
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		
		
		/* Collection 생성과 목록 DI */
		
		List<Exam> exams = new ArrayList<>();
		exams.add(new NewlecExam(1,1,1,1));
		
		for(Exam e : exams)
			System.out.println(e);
		
	}

	
}
