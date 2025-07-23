import java.util.Scanner;
public class GradeCalculator {
    public static void displaymark(int[] marks, String[] subjects){
        int total=0;
        int n = marks.length;
        System.out.println("----- Marksheet -----");
        for (int i=0;i<n;i++){
            System.out.println("Subject "+(i+1)+":"+subjects[i]+" Marks secured:"+marks[i]);
            total=total+marks[i];
        }
        int percentage = total/n;
        System.out.println("Total marks: "+total+" Percentage: "+percentage+"%");
        if (percentage>=90)
            System.out.println("Grade: O");
        else if(percentage>=80)
            System.out.println("Grade: A+");
        else if(percentage>=70)
            System.out.println("Grade: A");
        else if(percentage>=60)
            System.out.println("Grade: B+");
        else if(percentage>=50)
            System.out.println("Grade: B");
        else if(percentage>=45)
            System.out.println("Grade: C");
        else 
            System.out.println("Grade: U");
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of subjects:");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] subjects = new String[n];
        int[] marks = new int[n];

        System.out.println("Enter the subject name and mark in on line (eg. Maths 79):");
        for(int i = 0; i<n; i++){
            System.out.println("Subject "+(i+1)+":");
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            subjects[i] = parts[0];
            marks[i] = Integer.parseInt(parts[1]);
        }
        displaymark(marks, subjects);
        scanner.close();
    }
}
