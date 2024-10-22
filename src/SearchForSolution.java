import java.util.*;

public class SearchForSolution {
    private ArrayList<Staff> staffSet;
    private ArrayList<Project> projectSet;

    public SearchForSolution(ArrayList<Staff> staffSet, ArrayList<Project> projectSet) {
        this.staffSet = staffSet;
        this.projectSet = projectSet;
    }

    public ArrayList<Project> StartSearching() {
        ArrayList<Project> bestSolution = GenerateNewSolution();

        ArrayList<Project> newSolution;

        float valueOfBest = CalculateValueOfSolution(bestSolution);
        float newValue;
        System.out.println("Starting best solution :" + valueOfBest);

        for (int i = 0; i < Factorial(this.projectSet.size()); i++) {
            newSolution = GenerateNewSolution();
            newValue = CalculateValueOfSolution(newSolution);

            if (newValue > valueOfBest) {
                System.out.println("Found new best solution : " + newValue + " last was + " + valueOfBest);
                bestSolution = newSolution;
                valueOfBest = newValue;
            }
        }

        System.out.print("\nFinished searching for solution the value is : ");
        System.out.println(valueOfBest);
        return bestSolution;
    }

    private ArrayList<Project> GenerateNewSolution() {
        ArrayList<Project> helpSolution = new ArrayList<>();
        for (Project p : this.projectSet) {
            helpSolution.add(new Project(p));
        }

        ArrayList<Project> newSolution = new ArrayList<>(helpSolution);
        Collections.shuffle(newSolution);

        return Workplace.StartSimulatingStaff(this.staffSet, newSolution);
    }

    private float CalculateValueOfSolution(ArrayList<Project> solution) {
        float value = 0f;

        float ptsForFullProject = 20f;

        for (int i = 0; i < solution.size(); i++) {
            float help = 0f;
            if (solution.get(i).CalculateFreeWorkSpace() == 100) {
                help += ptsForFullProject;
            }
            help += solution.get(i).GetWorkplacesSet();
            help += (solution.get(i).GetWorkPlacesNumber() - solution.get(i).GetWorkplacesSet());

            value += help * solution.get(i).CalculateFreeWorkSpace();

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
