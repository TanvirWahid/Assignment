package assignment;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.*;

/**
 * This is a class to define the necessary attributes and methods to conceptualize a "Student"
 * The spepcific tasks are:
 * 1. Instiate 
 * 
 * @author Tanvir Wahid 
 * @version 22/10/16
 */
public class Student
{
    // Declare the important attributes of a student. For example:
    //1.Id
    //2. Name
    //3. Department
    //4. University
    //5. GPAs in various terms (Multidimensional arrays)
    //6. subjects for Current terms
    //7. Credits and grades of Current Terms (Multidimmentional Array)
   
	int ID,term,p,n,i,j;
	String Name,University,Department;
	double[] Gpa;
	double[][][] CnG;
	double cgpa;
	

    /**
     * Define a constructor that initilize the default properties of the Student
     */
    public Student()
    {
        // initialise   variables with defult values
    	ID=-1;
    	Name=null;
    	University=null;
    	Department=null;
    	term=0;
    	cgpa=0.0;
        Gpa=new double[10];
        CnG=new double[10][10][10];
    }
    /**
     * Define a method to print the students details.
     */
    
    public void studentDetailsById(int Id)
    {
        System.out.println("Student Name: "+Name+"\n");
        System.out.println("Student id: "+ID+"\n");
        System.out.println("University: "+University+"\n");
        System.out.println("Department: "+Department+"\n");
        System.out.println("CGPA: "+cgpa+"\n");
        
    }
    
    /**
     * Define a method to update information of students by ID
     * Use as many arguments as required.
     */
    public void updateStudentById(int id)
    {
        if(this.ID!=id){
        	return;
        }
        Scanner sc=new Scanner(System.in);
        if(ID==-1){
        	System.out.println("Enter student name: ");
        	Name=sc.nextLine();
        	System.out.println("Enter id: ");
        	ID=sc.nextInt();
        	System.out.println("Enter University: ");
        	
        	University=sc.nextLine();
        	University=sc.nextLine();
        	
        	System.out.println("Enter Department: ");
        	Department=sc.nextLine();
        	String ss=sc.nextLine();
        }
        
    }
    
    /**
     * Define a method to compute the CGPA from the Given term GPA for a particular student.
     * se as many arguments as required.
     */
    public double computeCGPAByID()
    {
    	double total=0.0;
    	for(int i=0; i<this.term; i++){
    		total+=Gpa[i];
    		
    	}
    return	this.cgpa=total/this.term;
    }
    
    /**
     * Define a method to compute the GPA from the given Credits and Grades of all the subjects
     */
    public void computeGPAById()
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter number of terms: ");
    	term=sc.nextInt();
    	double gpa,total;
    	for(int i=0; i<term; i++){
    		
    		System.out.println("Enter number of subjects in "+(i+1)+" th term");
    		n=sc.nextInt();
    		gpa=0.0; total=0.0;
    		for(int j=0; j<n; j++){
    			CnG[i][j][0]=sc.nextDouble();
    			CnG[i][j][1]=sc.nextDouble();
    			gpa+=CnG[i][j][0]*CnG[i][j][1];
    			total+=CnG[i][j][0];
    		}
    		Gpa[i]=gpa/total;
    	
    	}
    	
    	
    }
    
    /**
     * After performing required operations on each student, save the information to a file. Use File and PrintWriter Class. 
     * use as many arguments as required.
     * 
     */
    public void saveStudents() throws IOException
    {
        FileWriter output=new FileWriter("Student.txt",true);//Creates a file 
        
        BufferedWriter buffer=new BufferedWriter(output);//Create buffer to write
        PrintWriter Output = new PrintWriter(buffer);
    	
        Output.println("Student name: " +Name+"\n");
        
        Output.println("ID: "+ID+" \n");
        
        Output.println("University: "+University+ "\n");
        
        Output.println("Department: "+Department+"\n");
        
    	
    }
    
    /**
     * Create a dummy files with infromations to describe the properties of a Student object and load the data files using Java File and Scanner class.
     * use as many arguments as required.
     */
    public void loadStudents()
    {
        //Write your code here
        
    }
    
    /**
     * The tasks to be carried out here:
     * 1. Create an Arrays of students using Student Class. Initlize them and perfom all the above defined operation to evualuate your code.
     * use as many arguments as required.
     */
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	int n;
    	 System.out.println("Enter number of students: ");
    	 n=sc.nextInt();
    	Student[] abc=new Student[n+2];
    	for(int i=0; i<n; i++){
    		
    		abc[i]=new Student();
    		abc[i].updateStudentById(-1);
    		abc[i].computeGPAById();
    		double z=abc[i].computeCGPAByID();
    		abc[i].studentDetailsById(abc[i].ID);
    	}
    	
    }
}
