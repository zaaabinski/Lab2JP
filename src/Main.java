import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        if(args.length>=2)
        {
            System.out.println("Too many arguments");
            System.exit(-1);
        }
        else if(args[0].equals("-h"))
        {
            System.out.println("Usage: java -jar main.jar <Project and staff .txt file>");
            System.exit(0);
        }
        else if(args[0].startsWith("C"))
        {
            FileHandler FH = new FileHandler(args[0]);
            boolean validFile = FH.Validate();
            if (!validFile)
            {
                System.out.println("Wrong file path");
            }
            else
            {
                ArrayList<Staff> staff = FH.GetStaff();
                ArrayList<Project> projects = FH.GetProjects();

                SearchForSolution SFS = new SearchForSolution(staff,projects);

                ArrayList<Project> bestSolution = SFS.StartSearching();

                ShowResult(bestSolution);
            }
        }
        else
        {
            System.out.println("Wrong arguments use -h if you need help");
        }
    }

    private static void ShowResult(ArrayList<Project> projects)
    {
        for(Project p : projects)
        {
            System.out.println("For project : " + p.GetProjectNumber());
            if(p.assignedStaff.isEmpty())
            {
                System.out.println("No staff assigned");
            }
            for(String as : p.GetAssignedStaff())
            {
                System.out.println(as + " ");
            }
            if(p.GetWorkplacesSet()==p.GetWorkPlacesNumber())
            {
                System.out.println("All things set for the project");
            }
            System.out.println();
        }
    }
}