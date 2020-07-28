package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* DEPENDENCY INJECTION1 */
		Exam exam = new NewlecExam(10,10, 0, 0);
		ExamConsole console = new GridExamConsole(exam);
		console.print();
		
		/* DEPENDENCY INJECTION2 */
//		Exam exam = new NewlecExam(10,10, 0, 0);  
//		ExamConsole console = new GridExamConsole();
//		console.setExam(exam);
//		console.print();

	}

	
}
