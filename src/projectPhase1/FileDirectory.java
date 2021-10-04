package projectPhase1;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class FileDirectory {
	public static final String name = "src/projectPhase1/Directories/";
	
	ArrayList<File> files = new ArrayList<File>();
	
	Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
	
	File Dfiles = path.toFile();
	
	public String getPath() {
        return name;
    }
	
	 public ArrayList<File>allFiles() {
		 File[] directoryFiles = Dfiles.listFiles();
		 files.clear();
		 for (int i = 0; i < directoryFiles.length; i++) {
			 if (directoryFiles[i].isFile()) {
				 files.add(directoryFiles[i]);
			 }
		 }
		 Collections.sort(files);
		 return files;
	 }
	 
	 public ArrayList<File> getFiles() {
		 allFiles();
		 return files;
	 }
}
