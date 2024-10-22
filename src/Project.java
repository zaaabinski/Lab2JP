import java.util.*;

public class Project {

    private String projectNumber;
    private ArrayList<String> technologyNeeded;
    public ArrayList<String> assignedStaff;
    private int DoneWorkPlaces;
    private int workPlaces;


    public Project(String projectName, ArrayList<String> listOfProjects) {
        projectNumber = projectName;
        technologyNeeded = listOfProjects;
        workPlaces = technologyNeeded.size();
        assignedStaff = new ArrayList<>();
    }
    public Project(Project p)
    {
        this.projectNumber = p.projectNumber;
        this.technologyNeeded = new ArrayList<>(p.technologyNeeded); // Deep copy the list
        this.DoneWorkPlaces = p.DoneWorkPlaces;
        this.workPlaces = technologyNeeded.size();
        this.assignedStaff = new ArrayList<>(p.assignedStaff);
    }

    public int GetWorkPlacesNumber() {
        return this.workPlaces;
    }

    public int GetDoneWorkPlaces() {
        return this.DoneWorkPlaces;
    }

    public Float CalculateFreeWorkSpace()
    {
        return ((float)this.DoneWorkPlaces /this.workPlaces) * 100f;
    }

    public ArrayList<String> GetTechnologiesNeeded() {
        return this.technologyNeeded;
    }
    public ArrayList<String> GetAssignedStaff() {
        return this.assignedStaff;
    }

    public void AssignToProject(Project p,String str) {
        p.assignedStaff.add(str);
    }

    public int GetWorkplacesSet()
    {
        return this.DoneWorkPlaces;
    }
    public void IncreaseWorkplaces()
    {
        this.DoneWorkPlaces++;
    }
    public String GetProjectNumber()
    {
        return this.projectNumber;
    }
}
