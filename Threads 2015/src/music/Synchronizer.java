/*
 * Created on May 28, 2015
 *
 */
package music;

import javax.swing.JTextArea;

public class Synchronizer {
    
    private boolean leadLineFlag;
    private boolean soloFlag;
    
    private int brojac;
    
    public Synchronizer() {
    }

    public Synchronizer(boolean leadLineFlag, boolean soloFlag) {
        super();
        this.leadLineFlag = leadLineFlag;
        this.soloFlag = soloFlag;
        brojac = 0;
    }

    public synchronized void singLeadLine(String leadLine, long delay, JTextArea area) {
        while (!leadLineFlag || soloFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        singOneLine(leadLine, delay, area);
    }

    public synchronized void singBackingLine(String backingLine, long delay, JTextArea area) {
        while (leadLineFlag || soloFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        singOneLine(backingLine, delay, area);
        
        brojac++;
        if (brojac % 2 == 0) {
        	soloFlag = !soloFlag;
		}
    }
    
    private void singOneLine(String line, long delay, JTextArea area) {
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        area.setText(area.getText() + "\n");
        area.setText(area.getText() + line);
        leadLineFlag = !leadLineFlag;
        notifyAll();
    }
    
    public synchronized void playSolo(String solo, long delay, JTextArea area) {
    	while(!soloFlag) {
    	try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
    	}
    	
    	try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	area.setText(area.getText() + "\n");
    	area.setText(area.getText() + "\n");
    	area.setText(area.getText() + solo);
    	area.setText(area.getText() + "\n");
		
    	soloFlag = !soloFlag;
    	notifyAll();
    }

}
