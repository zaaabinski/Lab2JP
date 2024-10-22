import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandler {

    public String filePath;

    public FileHandler(String pathToFile) {
        this.filePath = pathToFile;
        System.out.println("File path: " + filePath);
    }

    public boolean Validate() {
        File inputFile = new File(filePath);
        try {
            Scanner fileScanner = new Scanner(inputFile);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return false;
        }
    }


    public ArrayList<Staff> GetStaff() throws FileNotFoundException
    {
        ArrayList<Staff> staff = new ArrayList<>();
        String readLine;
        File inputFile = new File(filePath);
        Scanner fileScanner = new Scanner(inputFile);

        while (fileScanner.hasNextLine())
        {
            readLine = fileScanner.nextLine();
            if (readLine.startsWith("R") && readLine.charAt(1) != 'R') {
                String[] str = readLine.split(": ");

                String staffName = str[0];
                String[] technologies = str[1].split(" ");

                ArrayList<String> staffTechnologies = new ArrayList<>();

                staffTechnologies.addAll(Arrays.asList(technologies));

                staff.add(new Staff(staffName, staffTechnologies));

            }
        }
        return staff;
    }

    public ArrayList<Project> GetProjects() throws FileNotFoundException
    {
        ArrayList<Project> projects = new ArrayList<>();
        String readLine;
        File inputFile = new File(filePath);
        Scanner fileScanner = new Scanner(inputFile);
        while (fileScanner.hasNextLine()) {
            readLine = fileScanner.nextLine();
            if (readLine.startsWith("P") && readLine.charAt(1) != 'R') {
                String[] str = readLine.split(": ");

                String projectName = str[0];

                String[] technologies = str[1].split(" ");

                ArrayList<String> projectTechnologies = new ArrayList<>();

                projectTechnologies.addAll(Arrays.asList(technologies));

                projects.add(new Project(projectName, projectTechnologies));
            }
        }
        return projects;
    }
}
