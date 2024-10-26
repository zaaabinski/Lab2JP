import java.util.*;

public class Workplace {

    public static ArrayList<Project> StartSimulatingStaff(ArrayList<Staff> staffSet, ArrayList<Project> projectSet) {

        ArrayList<Project> newProjectArrangement = new ArrayList<>();
        for (Project p : projectSet) {
            //set of technologies for each project
            ArrayList<String> workplacesToAssign = p.GetTechnologiesNeeded();
            for (Staff staffPerson : staffSet) {
                //technologies that each employee can do
                ArrayList<String> empTechnologies = staffPerson.GetTechnologyPerEmp();

                //iterate throught the workplaces that need job
                for (String t : new ArrayList<>(workplacesToAssign)) {
                    if (empTechnologies.contains(t) && staffPerson.CanWork(p.GetProjectNumber(),t) && p.GetDoneWorkPlaces() < p.GetWorkPlacesNumber())
                    {
                        //create a string str to store data for where certain person works and at what technology
                        String str = (staffPerson.GetStaffNumber() + " as " + t);

                        //adds staff to list of assigned people to work on this project
                        p.AssignToProject(p,str);

                        //insurances projects work on by this staff
                        staffPerson.IncreaseProjectsWorkedOn();

                        //sets main working place for current employee, if he is already working it doesnt change even if assigned second place at same project
                        if(staffPerson.GetProjectsWorkedOn()==0) {
                            staffPerson.SetWorkPlace(t);
                        }
                        //increases technologies that are found in this project
                        p.IncreaseWorkplaces();
                        //add project number for this employee so we can check if he can work on this project again
                        staffPerson.AddProjectThatStaffWorksOn(p.GetProjectNumber());
                        //removes certain technology from this project when it is found
                        workplacesToAssign.remove(t);
                    }
                }
            }
                newProjectArrangement.add(p);
        }
        return newProjectArrangement;
    }
}