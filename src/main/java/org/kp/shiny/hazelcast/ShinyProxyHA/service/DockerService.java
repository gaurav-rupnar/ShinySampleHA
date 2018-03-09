package org.kp.shiny.hazelcast.ShinyProxyHA.service;

import com.hazelcast.client.impl.HazelcastClientInstanceImpl;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.ISet;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DockerService {

  @Autowired
  private HazelcastInstance hz ;

  private IMap<Integer,String> launchingSet;

  public  void setLaunchingProxy(){
    launchingSet = hz.getMap("launchingProxy");
    Random r = new Random();
    launchingSet.set(r.nextInt(),"apple");
    System.out.println("************** adding apples");
  }

  public void getLaunchingProxy(){
    launchingSet = hz.getMap("launchingProxy");
    Random r = new Random();
    launchingSet.set(r.nextInt(),"apple");

    Set<Integer> set = launchingSet.keySet();
    for (Integer i : set){
      System.out.println("key => " + i+ "value => " +launchingSet.get(i));
    }


  }
}
