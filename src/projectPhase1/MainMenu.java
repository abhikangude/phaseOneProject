package projectPhase1;

import java.util.Scanner;

public class MainMenu {
	static FileDirectory fd=new FileDirectory();
	static FileOp fp=new FileOp();
	public static void Menu() {
		System.out.println("This is Menu-->");
		System.out.println("\n\t1. Show Files\n\t2. Perform Operations\n\t3. Close");
		
	}
	public static int getInput() {
		int ip=0;
		System.out.print("\nEnter your Choice: ");
		Scanner sc=new Scanner(System.in);
		ip=sc.nextInt();
		return ip;
	}
	public static void operations() {
		int ip;
		boolean complete=true;
		do {
			try {
				Menu();
				ip=getInput();
				switch(ip) {
				case 1:
					fp.showFiles();
					break;
				case 2:
					System.out.println("Perorm Operations-->");
					FileOperations();
					break;
				case 3:
					System.out.println("We are terminating the program.");
					complete=false;
					System.exit(0);
					break;
				default:
					System.out.println("INVALID INPUT!!!");
				}
			}catch(Exception e) {
				System.out.println("Please Enter Valid input!");
				operations();
			}
		}while(complete==true);
	}

	public static void FileOperations() {
		int op;
		boolean isEnd=true;
		do {
			try {
				System.out.println("\n\t1. Add file to directory\n\t2. Delete file from directory \n\t3. Search the file in directory \n\t4. Return to Operations Menu \n\t5. Exit from this tab.");
				op=getInput();
				switch(op) {
				case 1:
					fp.addFile();
					break;
				case 2:
					fp.deleteFile();
					break;
				case 3:
					fp.searchFile();
					break;
				case 4:
					return;
				case 5:
					isEnd=false;
					System.exit(0);
				default:
					System.out.println("INVALID INPUT!!!");
				}

			}catch(Exception e) {
				System.out.println("Please Enter Valid input!");
				FileOperations();
			}
	}while(isEnd=true);
	}
}

	