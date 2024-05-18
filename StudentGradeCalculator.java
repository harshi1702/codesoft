import java.util.Scanner;
public class StudentGradeCalculator
{
public static void main(String args[])
{ 
    Scanner s = new Scanner(System.in);
    System.out.println("Hello, Enter the Number of SUbjects:");
    int numSubjects = s.nextInt();
    int[] marks = new int[numSubjects];
    int totalMarks = 0;
    for (int i=0;i<numSubjects;i++)
    {
    System.out.println("Enter marks obtained in each subject"+(i+1)+":");
    marks[i] = s.nextInt();
    totalMarks += marks[i];
    }
    double averagePercentage = (double) totalMarks/(numSubjects*100)*100;
    System.out.println("Your Result is Here");
    System.out.println("Your Total Marks:"+totalMarks);
    System.out.println("Average Percentage:"+ averagePercentage +"%");
    String grade = calculateGrade(averagePercentage);
    System.out.println("Grade:"+grade);
    s.close();
}
public static String calculateGrade(double percentage)
{
    if(percentage >=90)
    {
        return"A+";
    }
    else if (percentage >= 80)
    {
        return"A";
    }
    else if (percentage >= 70)
    {
        return"B";
    }
    else if( percentage>=60)
    {
        return "c";
    }
    else if (percentage >= 50)
    {
        return "D";
    }
    else
    {
        return "F";
    }
}
}
