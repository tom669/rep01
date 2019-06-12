package com.emp.util;

import java.util.List;

public class Mgrnos {
	//数据中查询出的所有经理编号
   private List<String> mgrnos;

  public void setMgrnos(List<String> mgrnos) {
	this.mgrnos = mgrnos;
  }
  
  //类中有一个getContain(..)方法
  //jsp页面的EL表达式可以 ${Mgrnos对象.contain} --无参
  // ${Mgrnos对象.getContain(参数)} -- 有参
  public boolean getContain(String empno){
	    //判断参数传入的员工编号empno 是否存在于经理编号之中
	      return mgrnos.contains(empno); 
  }
	  
}
