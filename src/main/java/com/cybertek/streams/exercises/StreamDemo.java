package com.cybertek.streams.exercises;

import com.cybertek.enums.Gender;
import com.cybertek.enums.Status;
import com.cybertek.oop.encapsulation.User;
import com.cybertek.oop.inheritance.Project;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {


    public static List<Project> getListOfProjects(){

       return DataGenerator.getProjects();

    }

    public static List<Project> getListOfProjects(Status status){

        return getListOfProjects().stream().filter(project -> project.getProjectStatus().getValue().equals(status.getValue())).collect(Collectors.toList());

    }

    public static List<Project> getListOfProjects(User manager){

        return getListOfProjects().stream().filter(project -> project.getAssignedManager().getFirstName()
                .equals(manager.getFirstName()) && project.getAssignedManager().getLastName().equals(manager.getLastName())).collect(Collectors.toList());

    }

    public static List<Project> getProjectByProjectCode(String projectCode){

        return getListOfProjects().stream().filter(project -> project.getProjectCode().equals(projectCode)).collect(Collectors.toList());

    }

    public static List<User> getListOfUsers(){

        return DataGenerator.getUsers();

    }

    public static User getUserByFirstName(String firstName){

        return getListOfUsers().stream().filter(user -> user.getFirstName().equals(firstName)).findAny().get();

    }

    public static String getUserByUserId(Long id){

        return getListOfUsers().stream().filter(user -> user.getId() == id).findAny().get().toString();

    }

    public static List<User> deleteUser(String firstName){

        List<User> allUsers = getListOfUsers();
        List<User> forRemove = getListOfUsers().stream().filter(user -> user.getFirstName().equals(firstName)).collect(Collectors.toList());
        allUsers.removeAll(forRemove);
        return allUsers;

    }

    public static List<Project> updateProjectStatus(Status oldStatus, Status newStatus){

        List<Project> withOldStatus = getListOfProjects().stream().filter(project -> project.getProjectStatus().getValue().equals(oldStatus.getValue())).collect(Collectors.toList());
        withOldStatus.stream().forEach(project -> project.setProjectStatus(newStatus));
        return withOldStatus;

    }

    public static List<Project> findProjectByManager(User manager){

        return getListOfProjects(manager);

    }

    public static Integer totalProjectDurationForManager(User manager){

        List<Project> managersProjects = findProjectByManager(manager);
        Integer totalDuration = 0;
        for (Project managersProject : managersProjects) {
            totalDuration+=managersProject.getEndDate().compareTo(managersProject.getStartDate());
        }
        return totalDuration;
    }

    public static long findTotalMaleInCompany(){

        return getListOfUsers().stream().filter(user -> user.getGender().equals(Gender.MALE)).count() + DataGenerator.getManagers().stream().filter(manager -> manager.getGender().equals(Gender.MALE)).count();

    }

}
