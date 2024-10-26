import java.util.*;

public class SearchForSolution {
    private ArrayList<Staff> staffList;
    private ArrayList<Project> projectList;

    public SearchForSolution(ArrayList<Staff> staffList, ArrayList<Project> projectList) {
        this.staffList = staffList;
        this.projectList = projectList;
    }

    public ArrayList<Project> StartSearching() {
        ArrayList<Project> bestProjectArrangement = GenerateNewArrangement();

        ArrayList<Project> newProjectArrangement;

        float valueOfBestProjectArrangement = CalculateValueOfProjectArrangement(bestProjectArrangement);
        float valueOfNewProjectArrangement;

        System.out.println("Starting best arrangement :" + valueOfBestProjectArrangement);

        for (int i = 0; i <Factorial(this.projectList.size()); i++) {

            newProjectArrangement = GenerateNewArrangement();
            valueOfNewProjectArrangement = CalculateValueOfProjectArrangement(newProjectArrangement);

            if (valueOfNewProjectArrangement > valueOfBestProjectArrangement) {

                System.out.println("Found new best arrangement : " + valueOfNewProjectArrangement + " last was + " + valueOfBestProjectArrangement);

                bestProjectArrangement = newProjectArrangement;
                valueOfBestProjectArrangement = valueOfNewProjectArrangement;
            }
        }
        
        System.out.print("\nFinished searching for solution the value is : ");
        System.out.println(valueOfBestProjectArrangement);
        return bestProjectArrangement;
    }

    private ArrayList<Project> GenerateNewArrangement() {

        ArrayList<Project> helpArrangement = new ArrayList<>();
        for (Project p : this.projectList) {
            helpArrangement.add(new Project(p));
        }

        ArrayList<Project> newProjectArrangement = new ArrayList<>(helpArrangement);
        Collections.shuffle(newProjectArrangement);

        ArrayList<Staff> copiedStaff = new ArrayList<>();
        for (Staff s : this.staffList) {
            copiedStaff.add(new Staff(s));  // Deep copy each staff member
        }

        ArrayList<Staff> newStaff = new ArrayList<>(copiedStaff);
        Collections.shuffle(newStaff);
        return Workplace.StartSimulatingStaff(newStaff, newProjectArrangement);
    }

    private float CalculateValueOfProjectArrangement(ArrayList<Project> arrangement) {
        float value = 0f;

        float ptsForFullProject = 20f;

        for (int i = 0; i < arrangement.size(); i++) {
            float help = 0f;
            if (arrangement.get(i).CalculateFreeWorkSpace() == 100) {
                help += ptsForFullProject;
            }
            help += arrangement.get(i).GetWorkplacesSet();
            help += (arrangement.get(i).GetWorkPlacesNumber() - arrangement.get(i).GetWorkplacesSet());

            value += help * arrangement.get(i).CalculateFreeWorkSpace();

        }
        return value;
    }

    private static long Factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * Factorial(n - 1);
    }
}
