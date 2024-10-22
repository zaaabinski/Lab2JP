import java.util.*;

public class Workplace {

    public static ArrayList<Project> StartSimulatingStaff(ArrayList<Staff> staffSet, ArrayList<Project> projectSet) {

        ArrayList<Project> newSolution = new ArrayList<>();
        ArrayList<Staff> copiedStaff = new ArrayList<>();
        for (Staff s : staffSet) {
            copiedStaff.add(new Staff(s));  // Deep copy each staff member
        }

        for (Project p : projectSet) {
            //set of technologies for each project
            ArrayList<String> workplacesToAsign = p.GetTechnologiesNeeded();
            for (Staff staffPerson : copiedStaff) {
                //technologies that each employee can do
                ArrayList<String> empTechnologies = staffPerson.GetTechnologyPerEmp();

                //iterate throught the workplaces that need job
                for (String t : new LinkedHashSet<>(workplacesToAsign)) {
                    if (empTechnologies.contains(t) && staffPerson.CanWork() && p.GetDoneWorkPlaces() < p.GetWorkPlacesNumber())
                    {
                        String str = (staffPerson.GetStaffNumber() + " as " + t);
                        p.AssignToProject(p,str);
                        staffPerson.IncreaseProjectsWorkedOn();
                        staffPerson.SetWorkPlace(t);
                        p.IncreaseWorkplaces();

                        workplacesToAsign.remove(t);
                    }
                }
            }
                newSolution.add(p);
        }
        return newSolution;
    }
}