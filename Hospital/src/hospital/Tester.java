
package hospital;

/**
 *
 * @author RHAPSODY
 */
public class Tester {

   
    public static void main(String[] args) {
        WRM gg=new WRM();
        Patient p1=new Patient("Ruku",20,"B+");
        gg.RegisterPatient(p1);
        Patient p2=new Patient("Ashik",20,"B+");
        gg.RegisterPatient(p2);
        Patient p3=new Patient("Cook",61,"0+");
        gg.RegisterPatient(p3);
        
        
       gg.showAllPatient();
       //gg.CanDoctorGoHome();
       //gg.CancelAll();
       //gg.ServePatient();
       //gg.showAllPatient();
       
       
       
    }
    
}
