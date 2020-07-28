package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import spring.di.entity.Exam;

//@Component("console")
@Controller("console")
public class GridExamConsole implements ExamConsole {
	
	@Autowired(required=true)
	//@Qualifier("exam2")
	private Exam exam;
	
	public GridExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("TOTAL   |    AVG   ");
		System.out.printf("%3d   |    %3.2f   \n", exam.total(), exam.avg());
	}

	
	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam = exam;
	}

}
