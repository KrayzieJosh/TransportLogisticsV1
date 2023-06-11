package za.ac.cput.repository.repositoryImpl;

import za.ac.cput.domain.ProjectManager;
import za.ac.cput.repository.ProjectManagerRepository;

import java.util.HashSet;
import java.util.Set;

public class ProjectManagerRepositoryImpl implements ProjectManagerRepository {

   private static ProjectManagerRepositoryImpl projectManagerRepository=null;
   private Set<ProjectManager> projectManagerDb=null;
   private ProjectManagerRepositoryImpl(){
       projectManagerDb=new HashSet<ProjectManager>();

   }
   public static ProjectManagerRepositoryImpl getProjectManagerRepository(){
       if(projectManagerRepository==null){
           projectManagerRepository= new ProjectManagerRepositoryImpl();

       }
       return projectManagerRepository;
   }
   @Override
   public ProjectManager create(ProjectManager manager){
       boolean success= projectManagerDb.add(manager);
       if(!success){
           return null;


       }
       return manager;
   }
   @Override
   public ProjectManager read(String userId){
       for(ProjectManager manager:projectManagerDb){
           if(manager.getUserId().equals(userId));
           return manager;


       }
       return null;

   }
   @Override
   public ProjectManager update(ProjectManager manager){
     ProjectManager oldProjectManager=read(manager.getUserId());
     if(oldProjectManager!=null){
         projectManagerDb.remove(oldProjectManager);
         projectManagerDb.add(manager);
         return manager;

     }
       return null;
   }
   @Override
   public boolean delete(String userId){
       ProjectManager deleteProjectManager= read(userId);
       if(deleteProjectManager==null){
           return false;

       }
       projectManagerDb.remove(deleteProjectManager);
       return true;
   }

    public Set<ProjectManager> getAll() {
        return projectManagerDb;
    }



}
