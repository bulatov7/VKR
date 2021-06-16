package diplomEc;

import javax.speech.*;
import javax.speech.synthesis.*;
import java.util.Locale;
import java.io.IOException;
import com.leapmotion.leap.*;

class LeapListener extends Listener {
	public String mes = "";
	public boolean isSpace = false;
	public int chel = 1;
	public int qwe = 0;
//	public String letter = "";
	
	public String getMes() {
	       return mes;
	   }
	
    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        System.out.println("Please, wait 2 sec after each letter");
    }

    public void onDisconnect(Controller controller) {
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

    public void onFrame(Controller controller) {
        Frame frame = controller.frame();
        
        for(Hand hand : frame.hands()) {

            Vector normal = hand.palmNormal();
            Vector direction = hand.direction();

//          private void f1() {
//        		if (mes.charAt(mes.length()) != '1')
//        			mes = mes + "1";
//        	}
//        	private void f2() {
//        		if (mes.charAt(mes.length()) != '2')
//        			mes = mes + "2";
//        	}
            
            for (Finger finger : hand.fingers()) {

//            	System.out.println("qwe++");

//            	System.out.println(hand.fingers().get(2).bone(Bone.Type.TYPE_DISTAL).direction().getX());
//            	if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() > 0) {
//            		System.out.println("da");
//            	}
//            	else {
//            		System.out.println("net");
//            	}
            	
//            	//äëÿ ïðîâåðêè íîâûõ áóêâ
//            	if (normal.getX() > 0.7)
//        			if (Math.abs(hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX() - hand.fingers().get(1).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX())<10 &&
//    					Math.abs(hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).nextJoint().getY() - hand.fingers().get(1).bone(Bone.Type.TYPE_DISTAL).nextJoint().getY())<10)
//        				if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0 &&
//    						hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0 &&
//    						hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0 &&
//    						hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0) {
//        					System.out.println("0");
//        					try {
//                    			Thread.sleep(500);
//                    		} catch (InterruptedException e) {
//                    			// TODO Auto-generated catch block
//                    			e.printStackTrace();
//                    		}
//        				}
            					

            	
/////////////////////////////////////////////////////////////ÍÀ×ÀËÎ ÑÈÌÂÎËÎÂ      
            	
            	// 0 1 2 3 4 5 6 7 8 9
            	// a c d e j k m n o q r s t v w x
            	// space
            	if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0) //áîëüøîé êóëàê
                	if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0) //óêàçàòåëüíûé êóëàê
                		if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 && //îñòàëüíûå êóëàê
            				hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
        					hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
                			if(Math.abs(normal.getX())<0.3) 
//                				System.out.printf("Âû ïîêàçûâàåòå öèôðó 1%n");
//                				System.out.print(mes.endsWith("1"));
//                				letter = letter + " ";
//								if (letter.endsWith(" ")) 
									if (!mes.endsWith(" ") && !mes.equals("") ) {
	                        			mes = mes + " ";
//	                         			System.out.println(mes);
	                         			space();
//										sayIt(mes);     
//	                         			delMes();
	                         			
	                         	        try {
		                        			Thread.sleep(1000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
									}
								
                			
            	
            	//0
            	if (normal.getX() > 0.7)
        			if (Math.abs(hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX() - hand.fingers().get(1).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX())<10 &&
    					Math.abs(hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).nextJoint().getY() - hand.fingers().get(1).bone(Bone.Type.TYPE_DISTAL).nextJoint().getY())<10)
        				if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0 &&
    						hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0 &&
    						hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0 &&
    						hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ() < 0) {
//        					letter = letter + "0";
//							if (letter.endsWith("0")) 
								if (!mes.endsWith("0")) {
                        			mes = mes + "0";
                         			System.out.println(mes);
                         			try {
	                        			Thread.sleep(2000);
	                        		} catch (InterruptedException e) {
	                        			// TODO Auto-generated catch block
	                        			e.printStackTrace();
	                        		}
								}
							
        				}
            	
                // 1 or G
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0) //áîëüøîé êóëàê
                	if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0) //óêàçàòåëüíûé åñòü
                		if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 && //îñòàëüíûå êóëàê
            				hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
        					hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
                			if(Math.abs(normal.getX())<0.3) 
//                				System.out.printf("Âû ïîêàçûâàåòå öèôðó 1%n");
//                				System.out.print(mes.endsWith("1"));
//								letter = letter + "1";
//								if (letter.endsWith("1")) 
									if (!mes.endsWith("1")) {
	                        			mes = mes + "1";
	                         			System.out.println(mes);
	                         			try {
		                        			Thread.sleep(2000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
									}
								
                				
               			else if (hand.fingers().get(2).bone(Bone.Type.TYPE_DISTAL).direction().getZ()>-0.85)
               				if (!mes.endsWith("G")) {
                       			mes = mes + "G";
                        			System.out.println(mes);
								}
                	
                // 2 or H or U
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
	                		     hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (Math.abs(hand.fingers().get(1).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX() - hand.fingers().get(2).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX())>10) {
//	                					 System.out.printf("Âû ïîêàçûâàåòå öèôðó 2%n");
//	                					 letter = letter + "2";
//	 									 if (letter.endsWith("2")) 
	 										if (!mes.endsWith("2")) {
		                             			mes = mes + "2";
		                             			System.out.println(mes);
		                             			try {
				                        			Thread.sleep(2000);
				                        		} catch (InterruptedException e) {
				                        			// TODO Auto-generated catch block
				                        			e.printStackTrace();
				                        		}
		     								} 
	 									 
	                				 }
	                					 
//	                					 
	                				 else
	                					 if (!mes.endsWith("U")) {
	                             			mes = mes + "U";
	                              			System.out.println(mes);
	     								}
	                			 else  
	                				 if (!mes.endsWith("H")) {
	                         			mes = mes + "H";
	                          			System.out.println(mes);
	 								}
                
//                //P
               if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).center().getZ()<0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
	                		 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<-0.85)
	                			 if(normal.getX()>=0.3)
	                				 System.out.printf("Âû ïîêàçûâàåòå áóêâó P%n");
                
                // 3
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() < 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
                				 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (!mes.endsWith("3")) {
	                         			mes = mes + "3";
	                          			System.out.println(mes);
	                          			try {
		                        			Thread.sleep(2000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
	 								}
                
                //4 or B or F
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0)
                	if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0 &&
	                		 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (Math.abs(hand.fingers().get(1).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX() - hand.fingers().get(2).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX())>10 &&
                						 Math.abs(hand.fingers().get(2).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX() - hand.fingers().get(3).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX())>10 &&
        								 Math.abs(hand.fingers().get(3).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX() - hand.fingers().get(4).bone(Bone.Type.TYPE_DISTAL).nextJoint().getX())>10)
	                					 if (!mes.endsWith("4")) {
	                             			mes = mes + "4";
	                              			System.out.println(mes);
	                              			try {
			                        			Thread.sleep(2000);
			                        		} catch (InterruptedException e) {
			                        			// TODO Auto-generated catch block
			                        			e.printStackTrace();
			                        		}
	     								}
	                				 else
	                					 if (!mes.endsWith("B")) {
	                             			mes = mes + "B";
	                              			System.out.println(mes);
	     								}
               				 else
               					 if (!mes.endsWith("F")) {
                            			mes = mes + "F";
                             			System.out.println(mes);
    								}
                
                //5
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() < 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0 &&
	                		 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (!mes.endsWith("5")) {
	                         			mes = mes + "5";
	                          			System.out.println(mes);
	                          			try {
		                        			Thread.sleep(2000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
	 								}

                //6
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0 &&
	                		 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (!mes.endsWith("6")) {
	                         			mes = mes + "6";
	                          			System.out.println(mes);
	                          			try {
		                        			Thread.sleep(2000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
	 								}
                
                //7
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
	                		 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (!mes.endsWith("7")) {
	                         			mes = mes + "7";
	                          			System.out.println(mes);
	                          			try {
		                        			Thread.sleep(2000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
	 								}
                
                //8
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0 &&
	                		 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (!mes.endsWith("8")) {
	                         			mes = mes + "8";
	                          			System.out.println(mes);
	                          			try {
		                        			Thread.sleep(2000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
	 								}
                
                //9
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0)
	                if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
	                	 if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                		 if (hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0 &&
	                		 hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
	                 			if(Math.abs(normal.getX())<0.3) 
	                				 if (!mes.endsWith("9")) {
	                         			mes = mes + "9";
	                          			System.out.println(mes);
	                          			try {
		                        			Thread.sleep(2000);
		                        		} catch (InterruptedException e) {
		                        			// TODO Auto-generated catch block
		                        			e.printStackTrace();
		                        		}
	 								}
                
                //L
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() < 0) 
                	if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0) 
                		if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 && 
                		hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
                		hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0)
                 			if(Math.abs(normal.getX())<0.3) 
                				if (!mes.endsWith("L")) {
                       			mes = mes + "L";
                        			System.out.println(mes);
								}
                
                //I
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() > 0) 
                	if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0) 
                		if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 && 
                		hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
                		hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
                 			if(Math.abs(normal.getX())<0.3) 
                				if (!mes.endsWith("I")) {
                       			mes = mes + "I";
                        			System.out.println(mes);
								}
                
                //Y
                if (hand.fingers().get(0).bone(Bone.Type.TYPE_DISTAL).direction().getX() < 0) 
                	if (hand.fingers().get(1).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0) 
                		if (hand.fingers().get(2).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 && 
                		hand.fingers().get(3).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()<0 &&
                		hand.fingers().get(4).bone(Bone.Type.TYPE_INTERMEDIATE).direction().getZ()>0)
                 			if(Math.abs(normal.getX())<0.3) 
                				if (!mes.endsWith("Y")) {
                       			mes = mes + "Y";
                        			System.out.println(mes);
								}
                

		        if (!frame.hands().isEmpty()) {
		//            System.out.println();
		        }
		        
////////////////////////////////////////////////////ÊÎÍÅÖ ÑÈÌÂÎËÎÂ
            } 
            
        }

    }

	private void space() {
//		isSpace = true;
		sayIt(mes);
		delMes();
	}

	public void delMes() {
		mes ="";
//		isSpace = false;
		chel++;
        if (chel==2)
        	System.out.println("Skolko chelovek?");
	}

	public void sayIt(String mes) {
//////////////////////////////////////////////ÎÇÂÓ×ÊÀ
		try {
			EngineModeDesc desc = new EngineModeDesc(Locale.ENGLISH);
			System.out.println(desc.getLocale() + "qwe");
			System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
			Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
			Synthesizer synth1 = Central.createSynthesizer(desc);
//			System.out.println(synth1);
	
			synth1.allocate();
			synth1.resume();
			if (chel==1) 
				synth1.speakPlainText(mes+" days", null);
			else
				synth1.speakPlainText(mes+" people", null);
			synth1.waitEngineState(Synthesizer.QUEUE_EMPTY);
		
//			synth1.deallocate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	///////////////////////////////////////ÊÎÍÅÖ ÎÇÂÓ×ÊÈ   
	}
}






//____________________________________________________________________________________________________________________________________________
class LeapSignLang {
	
	public static void sayIt(String mes) {
		//////////////////////////////////////////////ÎÇÂÓ×ÊÀ
		try {
			EngineModeDesc desc = new EngineModeDesc(Locale.ENGLISH);
//			System.out.println(desc.getLocale() + "qwe");
			System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
			Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
			Synthesizer synth1 = Central.createSynthesizer(desc);
			//System.out.println(synth1);
			
			synth1.allocate();
			synth1.resume();
			synth1.waitEngineState(Synthesizer.QUEUE_EMPTY);
			
			synth1.speakPlainText(mes, null);
		
		//synth1.deallocate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	///////////////////////////////////////ÊÎÍÅÖ ÎÇÂÓ×ÊÈ   
	}
	
	private static void sleepp(int i) {
		try {
        	Thread.sleep(i);
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
    	LeapListener listener = new LeapListener();
        Controller controller = new Controller();

//        controller.addListener(listener);
        System.out.println("Initialized");
        System.out.println("Connected");
        
        System.out.println("Show symbols. Please, wait 2 sec after each letter");
        sayIt("Show symbols. Please, wait 2 sec after each letter");
        sleepp(5000);
        
        System.out.println("How many nights would you like to stay with us?");
        sayIt("how many nights would you like to stay with us?");
        sleepp(5000);
        

        

	    
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.removeListener(listener);
    }

	
    
    
    
}
