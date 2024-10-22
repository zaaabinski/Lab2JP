import java.util.*;

public class Workplace {

    public static ArrayList<Project> StartSimulatingStaff(ArrayList<Staff> staffSet, ArrayList<Project> projectSet) {

        ArrayList<Project> newSolution = new ArrayList<>();




        for (Project p : projectSet) {
            //set of technologies for each project
            ArrayList<String> workplacesToAsign = p.GetTechnologiesNeeded();
            for (Staff staffPerson : staffSet) {
                //technologies that each employee can do
                ArrayList<String> empTechnologies = staffPerson.GetTechnologyPerEmp();

                //iterate throught the workplaces that need job
                for (String t : new ArrayList<>(workplacesToAsign)) {
                    if (empTechnologies.contains(t) && staffPerson.CanWork(p.GetProjectNumber(),t) && p.GetDoneWorkPlaces() < p.GetWorkPlacesNumber())
                    {
                        String str = (staffPerson.GetStaffNumber() + " as " + t);
                        p.AssignToProject(p,str);
                        staffPerson.IncreaseProjectsWorkedOn();
                        staffPerson.SetWorkPlace(t);
                        p.IncreaseWorkplaces();
                        staffPerson.AddProjectThatStaffWorksOn(p.GetProjectNumber());
                        workplacesToAsign.remove(t);
                    }
                }
            }
                newSolution.add(p);
        }
        return newSolution;
    }
}