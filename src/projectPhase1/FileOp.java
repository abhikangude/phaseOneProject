package projectPhase1;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOp {
	Scanner sc= new Scanner(System.in);
	FileDirectory fd=new FileDirectory();
	
	public void showFiles() {
		fd.allFiles();
		for (File file:fd.allFiles())
        {
            System.out.println(file.getName());
        }
	}
	
	public void addFile() {
        System.out.print("\nTo create new File, Please Enter the Filename:");
        String fName =sc.nextLine();
        System.out.println("\n");
        System.out.println("You are adding file with name : "+fName);
		try {
			Path path = FileSystems.getDefault().getPath(FileDirectory.name+fName).toAbsolutePath();
			File file = new File(fd.getPath()+fName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File successfully created with name : "+file.getPath());
		    	  fd.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("File already exists in the directory.");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
	
	public void deleteFile() {
		System.out.print("\nTo Delete File, Please Enter the Filename:");
		String fName =sc.nextLine();
		System.out.println("\n");
		System.out.println("You are deleting file with name : "+fName);
		Path path = FileSystems.getDefault().getPath(FileDirectory.name+fName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()){
	    	  System.out.println("Deleted File: "+file.getName());
	    	  fd.getFiles().remove(file);
	      } else {
	        System.out.println("The File you want to delete is not in the directory");
	      }
	}
	
	public void searchFile() {
		Boolean flag=false;
		System.out.println("To search the File in directory, Please Enter the Filename:");
		String fName =sc.nextLine();
		System.out.println("\n");
		System.out.println("You are searching a file: "+fName);
        ArrayList<File> files = fd.getFiles();
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fName)) {
				System.out.println("File found in the directory");
				flag=true;
			}
        }
        if (flag==false) {
        	System.out.println("File not found!!!");
        }
    }
}
