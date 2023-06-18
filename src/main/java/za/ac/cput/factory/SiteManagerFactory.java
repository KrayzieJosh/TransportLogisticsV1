package za.ac.cput.factory;

import za.ac.cput.domain.Project;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.util.Helper;

import java.io.Serializable;
import java.util.List;

public class SiteManagerFactory implements Serializable {

   public static SiteManager createSiteManager(String userId,String userPosition,List<Project>userProjects){
       userId=Helper.generateID();
       if(Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(userPosition)
               || Helper.isNullOrEmpty(String.valueOf(userProjects))){
           return null;

       }
       return new SiteManager.SiteManagerBuilder().setUserId(userId)
               .setUserPosition(userPosition).setUserProjects(userProjects).build();

   }

}




