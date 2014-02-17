import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

//Classe du compteur
class CompteurLabel {
    
	private JLabel label;
    private Timer counterTimer;
    private int timeElapsed = 0;
    private Carte[] cartes;
    private boolean toutesRetournees = false;
    private boolean test;
    private int min = 0;
    private String minutes;
    private int sec;
    private String secondes;
    

    protected CompteurLabel(JLabel passedLabel, Carte[] cartes) {
       counterTimer = new Timer(1000, new CounterTimerListener());
       this.label = passedLabel;
       this.cartes = cartes;
       counterTimer.start();
    }

     private class CounterTimerListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
        	 timeElapsed++;
        	 test = true;	
        	 for(int i=0;i<cartes.length;i++){
	        		if(cartes[i].estCachee()) test = false;
	        	}
        	 if(test) toutesRetournees = true;
	            if (!toutesRetournees) {
	            	if(timeElapsed%60==0 && timeElapsed!=0) min++;
	            	sec = timeElapsed - min*60;
	            	if(sec<10 && min<10){ minutes = "0"+min; secondes = "0"+sec;}
	            	else if(sec>=10 && min<10) { minutes = "0"+min; secondes = ""+sec;}
	            	else if(sec>=10 && min>=10) { minutes = ""+min; secondes = ""+sec;}
	            	else if(sec<10 && min>=10) { minutes = ""+min; secondes = "0"+sec;}
	            	label.setText(minutes+":"+secondes);
	             } else{
	            	if(min==0) label.setText("Félicitations! Vous avez terminé en "+ sec+" secondes!");
	            	else label.setText("Félicitations! Vous avez terminé en "+min+" minutes et "+ sec+" secondes!");
	                counterTimer.stop();
	             }
             }
        	
     }
     
 }
