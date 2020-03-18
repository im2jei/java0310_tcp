package Server_Tr;

import java.util.ArrayList;

public class ServerCenter {
	private ArrayList<ServerChat> sList = new ArrayList<>();
	
	
	public void addServerChat(ServerChat s) {
		this.sList.add(s);
	}
	
	public void reMsg(String msg,String id) {
		// mes type
		// /to kkk hi~ good!   
		if(msg.indexOf("/to")==0) {
			//속삭속삭
			// 메시지 분석      
			int firstInt = msg.indexOf(" ")+1;
			int endInt = msg.indexOf(" ", firstInt);
			String targetID = msg.substring(firstInt, endInt);
			String targetMsg = "[@"+id+"]"+msg.substring(endInt+1);
			
			sendOne(targetID, targetMsg);
			
		}else {
			sendAll("["+id+"]"+msg);
		}
		
	}
	public void sendOne(String targetID, String targetMsg) {
		for(int i=0; i < sList.size(); i++) {
			if(targetID.equals(sList.get(i).getMyId())){
				sList.get(i).send(targetMsg);
			}
		}
	}
	public void sendAll(String msg) {
		for(int i=0; i < sList.size(); i++) {
			sList.get(i).send(msg);
		}
	}
	// 
	//
	//
	
	
	
	
	
	
	
	
	
	

}
