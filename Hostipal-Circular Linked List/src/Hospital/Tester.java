
package Hospital;

public class Tester {
    public static void main(String[] args) {
        WRM gg=new WRM();
        
        Patient p1=new Patient("RUKU",20,"B+");
        gg.RegisterPatient(p1);
        Patient p2=new Patient("ASHIK",20,"B+");
        gg.RegisterPatient(p2);
        Patient p3=new Patient("ENAM",25,"O+");
        gg.RegisterPatient(p3);
        Patient p4=new Patient("SHOINIK",40,"A-");
        gg.RegisterPatient(p4);
        Patient p5=new Patient("LOL",29,"A+");
        gg.RegisterPatient(p5);
        
      
        gg.ShowAllPatient();
        gg.ServePatient();
        gg.CanDoctorGoHome();
        gg.cancelAll();   
    }
}
