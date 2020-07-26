package spring.di;

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
		
		/* DEPENDENCY INJECTION2 */

//		Exam exam = new NewlecExam();
//		ExamConsole console = new GridExamConsole();
//		console.setExam(exam);
		
		/* ���������� �����ϴ� ������� �ڵ带 ���� */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		Exam exam = new NewlecExam();
		ExamConsole console = ?;
		console.setExam(exam);
		
		console.print();
	}

	
}
