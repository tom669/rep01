package com.emp.util;

import java.util.List;

public class Mgrnos {
	//�����в�ѯ�������о�����
   private List<String> mgrnos;

  public void setMgrnos(List<String> mgrnos) {
	this.mgrnos = mgrnos;
  }
  
  //������һ��getContain(..)����
  //jspҳ���EL���ʽ���� ${Mgrnos����.contain} --�޲�
  // ${Mgrnos����.getContain(����)} -- �в�
  public boolean getContain(String empno){
	    //�жϲ��������Ա�����empno �Ƿ�����ھ�����֮��
	      return mgrnos.contains(empno); 
  }
	  
}
