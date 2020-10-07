import java.io.File;
import java.io.IOException;

public class DropFolder {

	public static void main(String[] args) throws IOException {
		// read in the path of the input folder 
		
		String folderPath = "/Users/yuxinxie/Documents/folder";
		
		File[] list = new File(folderPath).listFiles();

		for (File folders : list) {
			
			if (folders.isDirectory()) {
				
				int folderCount = 0;
				
				for (File subfolder : folders.listFiles()) {
					if (subfolder.isDirectory()) {
						folderCount++;
						for (File source : subfolder.listFiles()) {
							if(source.getName().endsWith(".txt")) {
								source.renameTo(new File(source.getParentFile().getParent() + "\\" + source.getName()));
							}							
						}
					}
				}
				
				if(folderCount == 0) {
					
					System.err.println(folders.getName() + "did not create a two-layered folder");
				}
			}
		}

	}
}
